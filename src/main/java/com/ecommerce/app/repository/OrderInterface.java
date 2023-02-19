package com.ecommerce.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.app.model.Order;

public interface OrderInterface extends JpaRepository<Order, Integer>{

}
