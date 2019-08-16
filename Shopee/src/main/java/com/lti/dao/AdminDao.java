package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.entity.Admin;

@Repository
public class AdminDao {

	@PersistenceContext
	protected EntityManager entityManager;

	public Admin loginValidation(String email, String password) {
		String query = "select a from Admin a where a.email =:em and a.password=:pwd";
		Query q = entityManager.createQuery(query);
		q.setParameter("em", email);
		q.setParameter("pwd", password);
		try {
			Admin admin = (Admin) q.getSingleResult();
			return admin;
		} catch (Exception e) {
			return null;
		}
	}

}
