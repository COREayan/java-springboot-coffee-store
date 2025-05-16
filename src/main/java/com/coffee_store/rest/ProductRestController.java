package com.coffee_store.rest;

import com.coffee_store.entity.Product;
import com.coffee_store.service.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductRestController {
    
    private final ProductService productService;

    @GetMapping("/")
    public List<Product> findAll() {
        return productService.findAll();
    }
    
    @GetMapping("/{productId}")
    public Product findById(@RequestParam int productId) {
        Product theProduct = productService.findById(productId);
        if (theProduct == null) {
            throw new RuntimeException("Product id not found - " + productId);
        } 
        return theProduct;
    }
    
    @PostMapping("/")
    public Product createProduct(@RequestBody Product theProduct) {
        Product dbProduct = productService.save(theProduct);
        return dbProduct;
    }
    
    @PutMapping("/")
    public Product updateProduct(@RequestBody Product theProduct) {
        Product dbProduct = productService.save(theProduct);
        return dbProduct;
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable int productId) {
        Product tempProduct = productService.findById(productId);

        if (tempProduct == null) {
            throw new RuntimeException("Product id not found - " + productId);
        }
        productService.deleteById(productId);
        return "Deleted product id - " + productId;
    }


    public ProductRestController(ProductService theProductService) {
        productService = theProductService;
    }
}
