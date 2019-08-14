package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Product;
import com.lti.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/displayAllProduct.lti")
	public List<Product> displayAllProduct() {
		return productService.displayAllProduct();
	}
	
	@PostMapping("/displayAllProductByBrand.lti")
	public List<Product> displayAllProductByBrand(String brand) {
		return productService.displayProductByBrand(brand);
	}
	
	@PostMapping("/displayAllProductByPriceLowToHigh.lti")
	public List<Product> displayAllProductByPriceLowToHigh() {
		return productService.displayProductByPriceLowToHigh();
	}
	
	@PostMapping("/displayAllProductByPriceHighToLow.lti")
	public List<Product> displayAllProductByPriceHighToLow() {
		return productService.displayProductByPriceHighToLow();
	}
	
}
