package com.ecommerce.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.app.model.Product;
import com.ecommerce.app.repository.ProductInterface;
import com.ecommerce.app.services.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;
	
	//Create Product
	
	@PostMapping("/product")
	public Product addProduct(@RequestBody Product data) {
		return service.createProduct(data);
	}
	
	@GetMapping("/product/{prdct}")
	public List<Product> getProducts(@PathVariable("prdct") String prdct){
		return service.getAllProducts(prdct);
	}
	
	@DeleteMapping("/product/{id}")
	public Optional<Product> deleteProductById(@PathVariable("id") int id) {
		return service.deleteProduct(id);
	}
}
