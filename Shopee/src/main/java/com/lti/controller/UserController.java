package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.Credential;
import com.lti.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService UserService;

	@PostMapping("/UserLogin.lti")
	public String loginValidation(@RequestBody Credential credentials) {
		return UserService.userLogin(credentials.getEmail(), credentials.getPassword());
	}
}
