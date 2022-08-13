package com.example.demo.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Product;

@Repository
public class ProductRepository {
	Map<String, Product> products;

	public ProductRepository(Map<String, Product> products) {
		super();
		this.products = products;
	}
	
	public void save(Product product) {
		products.put(product.getName(), product);
	}
	
	public Product findByProductName(String name) {
		return products.get(name);
	}
	
	public List<Product> retrieveAllProducts(){
		return products.values().stream().collect(Collectors.toList());
	}
	
	public boolean existsByName(String name) {
		return products.containsKey(name);
	}

}
