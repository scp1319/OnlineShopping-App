package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.AdminDao;
import com.lti.entity.Admin;
import com.lti.entity.Retailer;

@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;

//	@Autowired
//	private GenericDao dao;

	@Transactional
	public Admin adminLogin(String email, String password) {
		return adminDao.loginValidation(email, password);
	}
	public List <Retailer> displayRetailer(int adminId) {
		return adminDao.displayRetailer(adminId);
	}

}