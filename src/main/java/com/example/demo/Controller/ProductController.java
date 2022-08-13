package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Service.ProductService;
import com.example.demo.model.Product;

@Controller
public class ProductController {
	private ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	
	@GetMapping("/")
	public String toIndex() {
		return "index";
	}
	
	@GetMapping("/addProduct")
	public String goToProduct(Model model) {
		model.addAttribute("product", new Product());
		return "addProduct";
	}
	
	@PostMapping("/createProduct")
	public String goToSave(Product product, Model model) {
		if(productService.createProduct(product)) {
			model.addAttribute("productName", product.getName());
			return "confirmation";
		}
		return "redirect:/addProduct";
	}
	
	@GetMapping("/products")
	public String showAllProducts(Model model) {
		List<Product> products = productService.getAllProducts();
		model.addAttribute("products", products);
		return "products";
	}
	
	@GetMapping("/product")
	public String toProduct(@RequestParam String name, Model model) {
		Product product = productService.findByProductName(name);
		if(product != null) {
			model.addAttribute("product", product);
			return "product-page";
		}
		return "product-not-found";
	}
	
	@GetMapping("/switchcase")
	public String checkSwitchCase(Model model) {
		Product product = productService.findByProductName("test");
		model.addAttribute("product", product);
		return "switchcase";
	}
	
}
