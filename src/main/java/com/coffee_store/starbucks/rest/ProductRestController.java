package com.coffee_store.starbucks.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.coffee_store.starbucks.entity.Product;
import com.coffee_store.starbucks.service.ProductService;

import java.util.List;


@RestController
@RequestMapping("product")
public class ProductRestController {
    
    private ProductService productService;

    public ProductRestController(ProductService theProductService) {
        productService = theProductService;
    }

    @GetMapping("/products")
    public List<Product> findAll() {
        return productService.findAll();
    }
    
    @GetMapping("/products/{productId}")
    public Product findById(@RequestParam int productId) {
        Product theProduct = productService.findById(productId);
        if (theProduct == null) {
            throw new RuntimeException("Product id not found - " + productId);
        } 
        return theProduct;
    }
    
    @PostMapping("/products")
    public Product createProduct(@RequestBody Product theProduct) {
        Product dbProduct = productService.save(theProduct);
        return dbProduct;
    }
    
    @PutMapping("/products")
    public Product updateProduct(@RequestBody Product theProduct) {
        Product dbProduct = productService.save(theProduct);
        return dbProduct;
    }

    @DeleteMapping("products/{productId}")
    public String deleteProduct(@PathVariable int productId) {
        Product tempProduct = productService.findById(productId);

        if (tempProduct == null) {
            throw new RuntimeException("Product id not found - " + productId);
        }
        productService.deleteById(productId);
        return "Deleted product id - " + productId;
    }
}