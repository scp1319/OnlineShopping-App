package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import org.springframework.stereotype.Repository;

import com.lti.entity.User;

@Repository
public class UserDao {
	
	@PersistenceContext
	protected EntityManager entityManager;

	public String loginValidation(String email, String password) {

		String query = "select u from User u where u.email =:em and u.password=:pwd";
		Query q = entityManager.createQuery(query);
		q.setParameter("em", email);
		q.setParameter("pwd", password);

		try {
		 User c = (User) q.getSingleResult();
		 return "true";
		}
		catch(Exception e) {
			return "false";
		}
	}

}
