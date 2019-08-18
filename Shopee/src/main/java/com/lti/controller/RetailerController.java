package com.lti.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.ChangeRetailerPasswordInfo;
import com.lti.dto.Credential;
import com.lti.dto.ProductInfo;
import com.lti.entity.Category;
import com.lti.entity.Retailer;
import com.lti.service.CategoryService;
import com.lti.service.RetailerService;

@RestController
public class RetailerController {
	@Autowired
	private RetailerService retailerService;

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/dispCategory.lti")
	public List<Category> dispCategory() {
		List<Category> list = categoryService.displayCategory();
		return list;
	}

	@PostMapping("/addProductInfo.lti")
	public void addProductInfo(ProductInfo info) {
		String path="D:\\new\\";
		String imagePath =info.getDocument().getOriginalFilename(); 
		String storagePath = path+imagePath; 
		try 
		{
		info.getDocument().transferTo(new File(storagePath));
		  } 
		 
		catch (IOException e) 
		{
		  e.printStackTrace();
		}
		retailerService.addProducts(info.getName(), info.getBrand(), info.getDescription(), info.getPrice(),
				info.getStock(), info.getRetailerId(), info.getCategoryId(), imagePath);
	
	}

	@PostMapping("/RetailerLogin.lti")
	public Retailer loginValidation(@RequestBody Credential credentials) {
		return retailerService.retailerLogin(credentials.getEmail(), credentials.getPassword());
	}
	@PostMapping("/changeRetailerPassword.lti")
	public boolean changePassword(@RequestBody ChangeRetailerPasswordInfo info)
	{
		return retailerService.changePassword(info.getRetailerId(), info.getPassword(), info.getNewpassword());
	}
}