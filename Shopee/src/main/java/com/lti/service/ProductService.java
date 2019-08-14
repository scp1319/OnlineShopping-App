package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.GenericDao;
import com.lti.entity.Product;

@Service
	public class ProductService {

		@Autowired
		private GenericDao dao;
		@Transactional
		public Product displayProduct(int product_id){
			return dao.fetchById(Product.class, product_id);
		}
}