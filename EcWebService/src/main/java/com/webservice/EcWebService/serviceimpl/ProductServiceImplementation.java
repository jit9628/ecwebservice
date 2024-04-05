package com.webservice.EcWebService.serviceimpl;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.webservice.EcWebService.dto.ProductDto;
import com.webservice.EcWebService.entity.Category;
import com.webservice.EcWebService.entity.Product;
import com.webservice.EcWebService.repository.CategoryRepository;
import com.webservice.EcWebService.repository.ProductRepository;
import com.webservice.EcWebService.service.ProductService;
@Service
public class ProductServiceImplementation implements ProductService{
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ModelMapper mapper;
	@Override
	public String addProduct(ProductDto productDto) {
		Product map = this.mapper.map(productDto, Product.class);
		Category category = this.categoryRepository.findById(productDto.getCategory()).get();
		map.setCategory(category);
		Product save = this.productRepository.save(map);
		return "Saved Succedd..";
	}
	@Override
	public List<Product> listOfProduct() {
		List<Product> all = this.productRepository.findAll();
		return all;
	}
}
