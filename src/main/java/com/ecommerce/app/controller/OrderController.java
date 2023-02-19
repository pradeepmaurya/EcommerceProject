package com.ecommerce.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.app.model.Order;
import com.ecommerce.app.services.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	//Getting Order by OrderId
	@GetMapping("/order/orderId/{id}")
	public Optional<Order> getOrderById(@PathVariable("id") int id) {
		return service.getOrderById(id);
	}
	
	//Creating Order
	@PostMapping("/order")
	public Order createOrder(@RequestBody String data) {
//		System.out.println("this is your print ------------**********"+data);
		return service.addOrder(data);
	}
	
	//Getting order By UserId
	@GetMapping("/order/userId/{id}")
	public List<Order> getOrderByUserId(@PathVariable int id){
		return service.getOrderByUserId(id);
	}
}
