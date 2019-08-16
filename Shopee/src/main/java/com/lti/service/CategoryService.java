package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.GenericDao;
import com.lti.entity.Category;
@Service
public class CategoryService {
	
	@Autowired
	private GenericDao dao;

	public List<Category> displayCategory(){
		List<Category> list=dao.fetchAll(Category.class);
		return list;
	}
}
