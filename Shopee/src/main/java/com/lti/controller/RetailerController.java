package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.ProductInfo;
import com.lti.entity.Category;
import com.lti.service.CategoryService;
import com.lti.service.RetailerService;
@RestController
public class RetailerController {
	@Autowired
	private RetailerService retailerService;
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/dispCategory.lti")
	public List<Category> dispCategory(){
		List<Category> list=categoryService.displayCategory();
		return list;
	}
	
	@PostMapping("/addProductInfo.lti")
	public void addProductInfo(@RequestBody ProductInfo info)
	{
		System.out.println(info.getRetailerId());
	retailerService.addProducts(info.getName(), info.getBrand(), info.getDescription(), info.getPrice(), info.getStock(), info.getRetailerId(), info.getCategoryId());	
	}
}
