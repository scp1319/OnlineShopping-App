package com.lti.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.UserDao;
import com.lti.entity.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public String userLogin(String email, String password) {
		return userDao.loginValidation(email, password);
	}
}
