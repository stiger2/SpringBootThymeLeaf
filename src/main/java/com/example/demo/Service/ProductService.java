package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.ProductRepository;
import com.example.demo.model.Product;

@Service
public class ProductService {
	private ProductRepository productRepo;
	
	@Autowired
	public ProductService(ProductRepository productRepo) {
		super();
		this.productRepo = productRepo;
	}
	
	public boolean createProduct(Product product) {
		if(productRepo.existsByName(product.getName())) {
			return false;
		}
		productRepo.save(product);
		return true;
	}
	
	public Product findByProductName(String name) {
		return productRepo.findByProductName(name);
	}
	
	public List<Product> getAllProducts(){
		return productRepo.retrieveAllProducts();
	}
	
}
