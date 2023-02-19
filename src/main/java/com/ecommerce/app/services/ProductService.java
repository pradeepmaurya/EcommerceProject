package com.ecommerce.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.app.model.Product;
import com.ecommerce.app.repository.ProductInterface;

@Service
public class ProductService {
	
	@Autowired
	private ProductInterface repo;
	
	//Create product
	public Product createProduct(Product data) {
		return repo.save(data);
	}
	
	// Get all Products on the base of category
	public List<Product> getAllProducts(String prdct){
		List<Product> findAll = repo.findAll();
		List<Product> list = new ArrayList<>();
		for(Product data:findAll) {
			if(data.getCategory().equals(prdct)) {
				list.add(data);
			}
		}
		
		return list;
	}
	
	//Delete Products based On Id
	public Optional<Product> deleteProduct(int id) {
		Optional<Product> findById = repo.findById(id);
		if(findById != null) {
			repo.deleteById(id);
			return findById;
		}
		return null;
	}
}
