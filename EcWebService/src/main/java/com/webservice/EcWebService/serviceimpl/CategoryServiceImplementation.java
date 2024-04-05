package com.webservice.EcWebService.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.webservice.EcWebService.entity.Category;
import com.webservice.EcWebService.repository.CategoryRepository;
import com.webservice.EcWebService.service.CategoryService;

@Service
public class CategoryServiceImplementation implements CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public String addCategory(Category category) {
		String message = "";
//	 first check category is available onr not 
		if (this.categoryRepository.existsByCategoryname(category.getCategoryname())) {
			message = "This Category Is Already Exists : " + category.getCategoryname();
			return message;
		} else {
			Category save = this.categoryRepository.save(category);
			message = "Category is Saved ..";
			return message;
		}
	}

	@Override
	public List<Category> listOfCategory() {

		List<Category> all = this.categoryRepository.findAll();
		return all;
	}

	@Override
	public void deleteCategory(int cid) {
		this.categoryRepository.deleteById(cid);

	}

}
