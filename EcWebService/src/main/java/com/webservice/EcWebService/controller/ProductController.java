package com.webservice.EcWebService.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.EcWebService.dto.CategoryDto;
import com.webservice.EcWebService.dto.ProductDto;
import com.webservice.EcWebService.entity.Category;
import com.webservice.EcWebService.entity.Product;
import com.webservice.EcWebService.service.CategoryService;
import com.webservice.EcWebService.service.ProductService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/test/")
public class ProductController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;
	@Autowired
	private ModelMapper mapper;
	
	
	
// ==================== Category endpoints====================
	
	
	// category add
	
	@PostMapping("addCategory")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> addCategory(@RequestBody CategoryDto category) {
		
		Category map = this.mapper.map(category, Category.class);
		String responsevalue = this.categoryService.addCategory(map);
		return new ResponseEntity<>(Map.of("message", responsevalue, "statusCod", "200"), HttpStatus.OK);
	}
	
	//category read
	@GetMapping("category/list")
	@PreAuthorize("hasRole('USER')")
public ResponseEntity<?> categoryList() {		
		List<Category> responsevalue = this.categoryService.listOfCategory();
		return new ResponseEntity<>(Map.of("message", responsevalue, "statusCod", "200"), HttpStatus.OK);
	}
	
	@DeleteMapping("del/{cid}")
	@PreAuthorize("hasRole('USER')")
public ResponseEntity<?> categoryDelete(@PathVariable("cid") int cid) {		
		try {
			
		
		 this.categoryService.deleteCategory(cid);
		return new ResponseEntity<>(Map.of("message", "Category Deleted", "statusCod", "200"), HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(Map.of("message", e, "statusCod", "200"), HttpStatus.OK);

		}
	}
	
	
	
	
	
	
	
	//===================Product End points ===============================
	@PostMapping("addproduct")
	@PreAuthorize("hasRole('USER')")
public ResponseEntity<?> addProduct(@RequestBody ProductDto dto) {		
		String responsevalue = this.productService.addProduct(dto);
		return new ResponseEntity<>(Map.of("message", responsevalue, "statusCod", "200"), HttpStatus.OK);
	}
	
	@GetMapping("productlist")
	@PreAuthorize("hasRole('USER')")
public ResponseEntity<?> productList() {
		
		List<Product> responsevalue = this.productService.listOfProduct();
		return new ResponseEntity<>(Map.of("message", responsevalue, "statusCod", "200"), HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
}
