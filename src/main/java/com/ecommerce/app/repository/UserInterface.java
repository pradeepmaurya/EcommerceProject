package com.ecommerce.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.app.model.User;

public interface UserInterface extends JpaRepository<User, Integer>{

}
