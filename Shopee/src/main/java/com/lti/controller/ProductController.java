package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Product;
import com.lti.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/dispProduct.lti")
	public Product displayAllEmployee(@RequestParam("productid") int prodid) {
		return productService.displayProduct(prodid);
	}
}
