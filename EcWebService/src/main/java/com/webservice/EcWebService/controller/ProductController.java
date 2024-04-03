package com.webservice.EcWebService.controller;

import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.EcWebService.cinfig.ModelMapperConfig;
import com.webservice.EcWebService.entity.Category;
import com.webservice.EcWebService.service.CategoryService;

@RestController
@RequestMapping("/api/test/")
public class ProductController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ModelMapper mapper;

	@PostMapping("addCategory")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> addCategory(@RequestBody Category category) {
		String responsevalue = this.categoryService.addCategory(category);

		return new ResponseEntity<>(Map.of("message", responsevalue, "statusCod", "200"), HttpStatus.OK);
	}

}
