package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.CartValue;
import com.lti.dto.Credential;
import com.lti.dto.RetailerDetails;
import com.lti.entity.Admin;
import com.lti.entity.Retailer;
import com.lti.service.AdminService;

@RestController
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	
	@PostMapping("/AdminLogin.lti")
	public Admin loginValidation(@RequestBody Credential credentials) {
		return adminService.adminLogin(credentials.getEmail(), credentials.getPassword());
	}
	
	@GetMapping("/DisplayRetailer.lti")
	public List <Retailer> displayRetailer(@RequestParam("adminId") int adminId) {
		return adminService.displayRetailer(adminId);
	}
	@DeleteMapping("/deleteRetailer.lti")
	public void deleteRetailer(@RequestParam("retailerId") int retailerId) {
		adminService.removeRetailer(retailerId);	
}
	@PostMapping("/addRetailer.lti")
	public void addRetailer(@RequestBody RetailerDetails retailerDetails) {
		adminService.addRetailer(retailerDetails.getPassword(), retailerDetails.getName(),retailerDetails.getEmail(),retailerDetails.getAdminId());
	}
}
