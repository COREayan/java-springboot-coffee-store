package com.coffee_store.rest;

import com.coffee_store.entity.Customer;
import com.coffee_store.service.CustomerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@RestController
@RequestMapping("/customers")
public class CustomerRestController {
    
    private CustomerService customerService;

    public CustomerRestController(CustomerService theCustomerService) {
        customerService = theCustomerService;
    }

    @GetMapping("/")
    public List<Customer> findAll() {
        return customerService.findAll();
    }
    
    @GetMapping("/{customerId}")
    public Customer findById(@PathVariable int customerId) {
        Customer theCustomer = customerService.findById(customerId);
        if (theCustomer == null) {
            throw new RuntimeException("Customer id not found - " + customerId);
        } 
        return theCustomer;
    }

    @PostMapping("/")
    public Customer createCustomer(@RequestBody Customer theCustomer) {
        theCustomer.setId(0);
        Customer dbCustomer = customerService.save(theCustomer);
        return dbCustomer;
    }
    
    @PutMapping("/")
    public Customer updateCustomer(@RequestBody Customer theCustomer) {
        Customer dbCustomer = customerService.save(theCustomer);
        return dbCustomer;
    }

    @DeleteMapping("/{customerId}")
    public String deleteCustomer(@PathVariable int customerId) {
        Customer tempCustomer = customerService.findById(customerId);

        if (tempCustomer == null) {
            throw new RuntimeException("Customer id not found - " + customerId);
        } 
        customerService.deleteById(customerId);
        return "Deleted customer id - " + customerId;
    }
}
