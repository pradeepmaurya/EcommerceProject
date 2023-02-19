package com.ecommerce.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.app.model.User;
import com.ecommerce.app.repository.UserInterface;

@Service
public class UserService {
	
	@Autowired
	private UserInterface repo;
	
	//Creating User
	public User addUser(User data) {
		return repo.save(data);
	}
	
	//Getting USer
	public User getUser(int id) {
		List<User> findAll = repo.findAll();
		for(User user:findAll) {
			if(user.getUserId() == id) {
				return user;
			}
		}
		return null;
	}
	
}
