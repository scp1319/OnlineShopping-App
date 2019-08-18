package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.entity.Product;
import com.lti.entity.Retailer;

@Repository
public class RetailerDao {

	@PersistenceContext
	protected EntityManager entityManager;

	public Retailer loginValidation(String email, String password) {
		String query = "select r from Retailer r where r.email =:em and r.password=:pwd";
		Query q = entityManager.createQuery(query);
		q.setParameter("em", email);
		q.setParameter("pwd", password);
		try {
			Retailer retailer = (Retailer) q.getSingleResult();
			return retailer;
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<Product> displayProductByRetailerId(int retailerId){
		String query = "select p from Product p where p.retailer.retailerId =:retailerId";
		Query q = entityManager.createQuery(query);
		q.setParameter("retailerId", retailerId);
		return q.getResultList();
	}

}
