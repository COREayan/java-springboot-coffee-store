package com.coffee_store.starbucks.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee_store.starbucks.entity.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    
}
