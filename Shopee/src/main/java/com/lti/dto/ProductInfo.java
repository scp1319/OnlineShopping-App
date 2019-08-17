package com.lti.dto;

import org.springframework.web.multipart.MultipartFile;

public class ProductInfo {
private String name;
private String brand;
private String description;
private double price;
private int stock;
private int retailerId;
private int categoryId;
private MultipartFile document;

public ProductInfo() {
	// TODO Auto-generated constructor stub
}
public MultipartFile getDocument() {
	return document;
}

public void setDocument(MultipartFile document) {
	this.document = document;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock = stock;
}
public int getRetailerId() {
	return retailerId;
}
public void setRetailerId(int retailerId) {
	this.retailerId = retailerId;
}
public int getCategoryId() {
	return categoryId;
}
public void setCategoryId(int categoryId) {
	this.categoryId = categoryId;
}

}
