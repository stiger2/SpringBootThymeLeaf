package com.example.demo.model;

public class Product {
	private String name;
	private String description;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", description=" + description + "]";
	}
	
	
	
}
