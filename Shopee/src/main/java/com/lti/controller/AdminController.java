package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.Credential;
import com.lti.dto.EditUserInfo;
import com.lti.dto.Status;
import com.lti.entity.Admin;
import com.lti.entity.Product;
import com.lti.entity.User;
import com.lti.service.AdminService;
import com.lti.service.ProductService;
import com.lti.service.SendMailService;
import com.lti.service.UserService;

@RestController
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private SendMailService sendMailService;
	
	@PostMapping("/adminLogin.lti")
	public Admin loginValidation(@RequestBody Credential credentials) {
		return adminService.adminLogin(credentials.getEmail(), credentials.getPassword());
	}
}
