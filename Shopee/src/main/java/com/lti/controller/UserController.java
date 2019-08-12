package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.Credential;
import com.lti.dto.Status;
import com.lti.entity.User;
import com.lti.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/UserLogin.lti")
	public String loginValidation(@RequestBody Credential credentials) {
		return userService.userLogin(credentials.getEmail(), credentials.getPassword());
	}
	
	@PostMapping("/RegisterUser.lti")
	public Status add(@RequestBody User user) {
		int userId=userService.userRegistration(user);
		Status status= new Status();
		status.setMessage("user added");
		status.setGeneratedId(userId);
		return status;
	}
	
}
