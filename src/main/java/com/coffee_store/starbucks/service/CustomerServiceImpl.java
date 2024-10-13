package com.coffee_store.starbucks.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.coffee_store.starbucks.entity.Customer;
import com.coffee_store.starbucks.dao.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
    
    private CustomerRepository customerRepository;
    
    public CustomerServiceImpl(CustomerRepository theCustomerRepository) {
        this.customerRepository = theCustomerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(int theId) {
        Optional<Customer> result = customerRepository.findById(theId);

        Customer theCustomer = null; 

        if (result.isPresent()) {
            theCustomer = result.get();
        } else {
            throw new RuntimeException("Did not find customer id - " + theId);
        }

        return theCustomer;
    }

    @Override
    public Customer save(Customer theCustomer) {
        return customerRepository.save(theCustomer);
    }

    @Override
    public void deleteById(int theId) {
        customerRepository.deleteById(theId);
    }
}


