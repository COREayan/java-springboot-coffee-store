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

import com.coffee_store.starbucks.entity.Customer;
import com.coffee_store.starbucks.service.CustomerService;

import java.util.List;


@RestController
@RequestMapping("customer")
public class CustomerRestController {
    
    private CustomerService customerService;

    public CustomerRestController(CustomerService theCustomerService) {
        customerService = theCustomerService;
    }

    @GetMapping("/customers")
    public List<Customer> findAll() {
        return customerService.findAll();
    }
    
    @GetMapping("/customers/{customerId}")
    public Customer findById(@RequestParam int customerId) {
        Customer theCustomer = customerService.findById(customerId);
        if (theCustomer == null) {
            throw new RuntimeException("Customer id not found - " + customerId);
        } 
        return theCustomer;
    }

    @PostMapping("/customers")
    public Customer createCustomer(@RequestBody Customer theCustomer) {
        theCustomer.setId(0);
        Customer dbCustomer = customerService.save(theCustomer);
        return dbCustomer;
    }
    
    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer theCustomer) {
        Customer dbCustomer = customerService.save(theCustomer);
        return dbCustomer;
    }

    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId) {
        Customer tempCustomer = customerService.findById(customerId);

        if (tempCustomer == null) {
            throw new RuntimeException("Customer id not found - " + customerId);
        } 
        customerService.deleteById(customerId);
        return "Deleted customer id - " + customerId;
    }
}
