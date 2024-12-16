package com.coffee_store.starbucks.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee_store.starbucks.entity.OrderItem;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
    
}
