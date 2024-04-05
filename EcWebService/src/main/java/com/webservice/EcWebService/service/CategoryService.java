package com.webservice.EcWebService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.webservice.EcWebService.entity.Category;

public interface CategoryService {

	
	public String addCategory(Category category);
	
	public List<Category> listOfCategory();
	
	public void deleteCategory( int cid);
	
}
