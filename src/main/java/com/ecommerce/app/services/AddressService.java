package com.ecommerce.app.services;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.app.model.Address;
import com.ecommerce.app.model.User;
import com.ecommerce.app.repository.AddressInterface;
import com.ecommerce.app.repository.UserInterface;

@Service
public class AddressService {
	
	@Autowired
	private AddressInterface repo;
	
	@Autowired
	private UserInterface userRepo;
	
	@Autowired
	private UserService service;
	//Create Address
	public Address addAddress(String data) {
		org.json.JSONObject json = new org.json.JSONObject(data);
//		json.getString("addressName")
	    
		Address address = setAddress(json); 
		
		repo.save(address);
		return address;
	}
	private Address setAddress(JSONObject json) {
		Address address = new Address();
		
		address.setAddressId(json.getInt("addressId"));
		address.setAddressName(json.getString("addressName"));
		address.setLandmark(json.getString("landmark"));
		address.setZipCode(json.getString("zipCode"));
		address.setState(json.getString("state"));
		address.setPhoneNo(json.getString("phoneNo"));
		
		String user_id = json.getString("user_id");
		User user = null;
		List<User> findAll = userRepo.findAll();
		for(User data:findAll) {
			if(data.getUserId() == Integer.valueOf(user_id)) {
				user = data;
				break;
			}
		}
		
		address.setUser_id(user);
		return address;
	}
}
