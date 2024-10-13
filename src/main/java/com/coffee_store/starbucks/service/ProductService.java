package com.coffee_store.starbucks.service;

import java.util.List;

import com.coffee_store.starbucks.entity.Product;

public interface ProductService {
    
    List<Product> findAll();

    Product findById(int theId);

    Product save(Product theProduct);

    void deleteById(int theId);
}
