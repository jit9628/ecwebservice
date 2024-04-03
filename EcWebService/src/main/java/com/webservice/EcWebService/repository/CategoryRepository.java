package com.webservice.EcWebService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservice.EcWebService.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
	boolean existsByCategoryname(String categoryname);

}
