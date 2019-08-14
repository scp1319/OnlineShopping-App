package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.GenericDao;
import com.lti.dao.ProductDao;
import com.lti.entity.Product;

@Service
	public class ProductService {

		@Autowired
		private GenericDao dao;
		
		@Autowired
		private ProductDao productDao;
		
		@Transactional
		public List<Product> displayAllProduct(){
			return dao.fetchAll(Product.class);
		}
		
		@Transactional
		public List<Product> displayProductByBrand(String brand){
			return productDao.fetchByBrandName(brand);
		}
		
		@Transactional
		public List<Product> displayProductByPriceLowToHigh(){
			return productDao.fetchByPriceLowToHigh();
		}
		
		@Transactional
		public List<Product> displayProductByPriceHighToLow(){
			return productDao.fetchByPriceHighToLow();
		}
		
}