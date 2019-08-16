package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.GenericDao;
import com.lti.dao.UserDao;
import com.lti.entity.Cart;
import com.lti.entity.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private GenericDao dao;

	@Transactional
	public User userLogin(String email, String password) {
		return userDao.loginValidation(email, password);
	}

	@Transactional
	public int userRegistration(User user) {
		User updatedUser = (User) dao.save(user);
		User u = dao.fetchById(User.class, updatedUser.getId());

		// generate cart for new user
		Cart c = new Cart();
		c.setUser(u);
		dao.save(c);
		return updatedUser.getId();
	}

	@Transactional
	public User userDetails(int userId) {
		return dao.fetchById(User.class, userId);
	}

	@Transactional
	public void editUserDetails(int userId, String name, String email, long mobno, String address) {
		User u = dao.fetchById(User.class, userId);
		u.setName(name);
		u.setEmail(email);
		u.setMobNo(mobno);
		u.setAddress(address);
		dao.save(u);
	}
	@Transactional
	public void changePassword(String password,String newpassword) {
		User u=userDao.fetchByPassword(password);
		u.setPassword(newpassword);
		dao.save(u);
	}
}