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
import com.lti.entity.Product;
import com.lti.entity.User;
import com.lti.service.ProductService;
import com.lti.service.SendMailService;
import com.lti.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private SendMailService sendMailService;
	
	@PostMapping("/UserLogin.lti")
	public User loginValidation(@RequestBody Credential credentials) {
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
	@PostMapping("/editUserDetails.lti")
	public void editUser(@RequestBody EditUserInfo  info){
		userService.editUserDetails(info.getUserId(),info.getName(),info.getEmail(),info.getMobileno(),info.getAddress());
	}
	
	@GetMapping("/sendMail.lti")
	public void sendMail() {
		sendMailService.send();
	}

}
