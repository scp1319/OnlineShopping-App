package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.dto.CartDetails;
import com.lti.entity.*;


@Repository
public class CartDao{

	@PersistenceContext
	protected EntityManager entityManager;

	public List<Item> displayCart(int cartId) {
		String query = "select i from Item i  where i.cart.cartId=:cartId";
		Query q = entityManager.createQuery(query);
		q.setParameter("cartId", cartId);
		return q.getResultList();
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
