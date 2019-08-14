package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.entity.Product;

@Repository
public class ProductDao {
	@PersistenceContext
	protected EntityManager entityManager;
	
	public List<Product> fetchByBrandName(String brand) {
		String query = "select p from Product p where p.brand =:brand";
		Query q = entityManager.createQuery(query);
		q.setParameter("brand", brand);
		return q.getResultList();
	}
	
	public List<Product> fetchByPriceLowToHigh() {
		String query = "select p from Product p order by p.price";
		Query q = entityManager.createQuery(query);
		
		return q.getResultList();
	}
	
	public List<Product> fetchByPriceHighToLow() {
		String query = "select p from Product p order by p.price desc";
		Query q = entityManager.createQuery(query);
		
		return q.getResultList();
	}
}
