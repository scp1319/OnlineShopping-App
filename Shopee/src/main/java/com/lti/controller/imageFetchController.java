package com.lti.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dao.GenericDao;
import com.lti.entity.Product;

@RestController
public class imageFetchController {
	
	@Autowired
	private GenericDao dao;
	@Autowired
	private ServletContext context;
	
	@GetMapping("/fetchImage.lti")
	public void copyFile(@RequestParam("productId")int productId, HttpServletRequest request) {
	 Product product= dao.fetchById(Product.class, productId);
	 String projlocation = context.getRealPath("/");
	 System.out.println(projlocation);
	 new File(projlocation + "/new").mkdir();
	 
	 File srcfile1 = new File("d:/new/"+product.getImagePath());
	 File destfile1 = new File(projlocation + "/new/" + product.getImagePath());
	 try {
	  FileUtils.copyFile(srcfile1, destfile1);
	 } catch (IOException e) {
	  e.printStackTrace();
	 }
	 
	 
	 
	 
	}
}
