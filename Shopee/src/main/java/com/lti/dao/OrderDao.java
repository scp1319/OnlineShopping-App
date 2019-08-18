package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.entity.Item;
import com.lti.entity.Order;

@Repository
public class OrderDao {
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	public List<Order> getOrderList(int userId) {
		String query = "select o from Order o where o.user.id=:userId";
		Query q = entityManager.createQuery(query);
		q.setParameter("userId", userId);
		return q.getResultList();
	}
}
