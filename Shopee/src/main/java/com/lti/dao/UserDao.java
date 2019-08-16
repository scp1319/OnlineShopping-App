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

	public User loginValidation(String email, String password) {
		String query = "select u from User u where u.email =:em and u.password=:pwd";
		Query q = entityManager.createQuery(query);
		q.setParameter("em", email);
		q.setParameter("pwd", password);
		try {
			User user = (User) q.getSingleResult();
			return user;
		} catch (Exception e) {
			return null;
		}
	}
	public User fetchByPassword(String password)
	{
		String query = "select u from User u where u.password=:pwd";
		Query q = entityManager.createQuery(query);
		q.setParameter("pwd", password);
		User user=(User) q.getSingleResult();
		return user;
	}

}
