package com.coffee_store.starbucks.service;

import java.util.List;

import com.coffee_store.starbucks.entity.Customer;

public interface CustomerService {
    
    List<Customer> findAll();

    Customer findById(int theId);

    Customer save(Customer thecuCustomer);

    void deleteById(int theId);
}
