package com.coffee_store.starbucks.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee_store.starbucks.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    
}
