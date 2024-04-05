package com.webservice.EcWebService.service;

import java.util.List;

import com.webservice.EcWebService.dto.ProductDto;
import com.webservice.EcWebService.entity.Product;



public interface ProductService {

	public String addProduct(ProductDto productDto);
	public List<Product> listOfProduct();
}
