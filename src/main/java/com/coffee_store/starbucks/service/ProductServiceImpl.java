package com.coffee_store.starbucks.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.coffee_store.starbucks.dao.ProductRepository;
import com.coffee_store.starbucks.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();    
    }

    @Override
    public Product findById(int theId) {
        Optional<Product> result = productRepository.findById(theId);
        
        Product theProduct = null;

        if (result.isPresent()) {
            theProduct = result.get();
        } else {
            throw new RuntimeException("Did not find product id - " + theId);
        }

        return theProduct;   
    }

    @Override
    public Product save(Product theProduct) {
        return productRepository.save(theProduct);
    }

    @Override
    public void deleteById(int theId) {
        productRepository.deleteById(theId);
    }

    public ProductServiceImpl(ProductRepository theProductRepository) {
        this.productRepository = theProductRepository;
    }
}
