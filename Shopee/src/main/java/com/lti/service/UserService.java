package com.lti.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.GenericDao;
import com.lti.dao.UserDao;
import com.lti.entity.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private GenericDao dao;
	
	@Transactional
	public String userLogin(String email, String password) {
		return userDao.loginValidation(email, password);
	}
	
	@Transactional
	public int userRegistration(User user) {
		User updatedUser=(User)dao.save(user);
		return updatedUser.getId();
	}	
}
