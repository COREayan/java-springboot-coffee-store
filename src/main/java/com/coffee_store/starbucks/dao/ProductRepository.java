package com.coffee_store.starbucks.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee_store.starbucks.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    
}
