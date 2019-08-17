package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.entity.User;
import com.lti.dto.CartDetails;
import com.lti.entity.*;

@Repository
public class CartDao {

	@PersistenceContext
	protected EntityManager entityManager;

	public Cart displayCart(int cartId) {
		String query = "select c from Cart c join fetch c.items where c.cartId=:id";
		Query q = entityManager.createQuery(query);
		q.setParameter("id", cartId);
		return (Cart) q.getSingleResult();
	}
	
	
	public Cart fetchCartByUserId(int userId) {
		String query = "select c from Cart c where c.user.id=:userId";
		Query q = entityManager.createQuery(query);
		q.setParameter("userId", userId);
		Cart c=(Cart)q.getSingleResult();
		System.out.println("Cart Id "+c.getCartId());
		
		return (Cart) q.getSingleResult();
	}
}
