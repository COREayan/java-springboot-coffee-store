package com.coffee_store.starbucks.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee_store.starbucks.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    
}