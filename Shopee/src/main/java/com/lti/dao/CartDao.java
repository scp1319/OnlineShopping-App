package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.entity.User;
import com.lti.entity.*;
@Repository
public class CartDao {

	@PersistenceContext
	protected EntityManager entityManager;
/*
	public CartDetails displayCart(int cartid) {
		String query = "select c from Cart c join fetch c.items where c.cartid=:id";
		Query q = entityManager.createQuery(query);
		q.setParameter("id", cartid);
		Cart cart = (Cart) q.getSingleResult();
		for(Item item : car
				
				
				t.getItems()) {
			Product prod = item.getProduct();
		}
}*/
}
