package com.ecommerce.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.h2.util.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.app.model.Address;
import com.ecommerce.app.model.Order;
import com.ecommerce.app.model.Product;
import com.ecommerce.app.model.User;
import com.ecommerce.app.repository.AddressInterface;
import com.ecommerce.app.repository.OrderInterface;
import com.ecommerce.app.repository.ProductInterface;
import com.ecommerce.app.repository.UserInterface;

@Service
public class OrderService {

	@Autowired
	private OrderInterface repo;
	
	@Autowired
	private UserInterface userRepo;
	
	@Autowired 
	private ProductInterface productRepo;
	
	@Autowired
	private AddressInterface addressRepo;
	
	
	//Creating Order
	public Order addOrder(String data) {
		
		org.json.JSONObject json = new org.json.JSONObject(data);
//		System.out.println("this is your print ------------**********"+data);
		Order order = setOrder(json);
		
		return repo.save(order);
	}
	
	private Order setOrder(org.json.JSONObject json) {
		Order order = new Order();
		
		order.setOrderId(json.getInt("OrderId"));
		order.setProductQty(json.getInt("productQty"));
		
		// Fetching data from user Class
		int userId = json.getInt("userId");
//		System.out.println("this is your print ------------**********"+userId);
		User user = userRepo.findById(userId).get();
		order.setUserId(user);
		//Fetching data from Product Class
		int productId = json.getInt("productId");
		Product product = productRepo.findById(productId).get();
		order.setProductId(product);
		
		//Fetching data from Address Class
		int addressId = json.getInt("addressId");
		Address address = addressRepo.findById(addressId).get();
		order.setAddressId(address);
		
		return order;
	}

	//Getting Order by OrderId
	public Optional<Order> getOrderById(Integer id) {
		return repo.findById(id);
	}
	
	//Getting Order By userId
	public List<Order> getOrderByUserId(int id) {
		List<Order> findAll = repo.findAll();
		List<Order> list = new ArrayList<>();
		for(Order data:findAll) {
			if(data.getUserId().getUserId() == id) {
				list.add(data);
			}
		}
		
		return list;
	}
}
