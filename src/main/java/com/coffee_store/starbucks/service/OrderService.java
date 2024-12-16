package com.coffee_store.starbucks.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.coffee_store.starbucks.dao.CustomerRepository;
import com.coffee_store.starbucks.dao.OrderRepository;
import com.coffee_store.starbucks.dao.ProductRepository;
import com.coffee_store.starbucks.entity.Customer;
import com.coffee_store.starbucks.entity.Order;
import com.coffee_store.starbucks.entity.OrderItem;
import com.coffee_store.starbucks.entity.Product;

import jakarta.transaction.Transactional;

@Service
public class OrderService {
    
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    @Transactional
    public Order placeOrder(int customerId, List<OrderItem> orderItems) {
        Optional<Customer> result = customerRepository.findById(customerId);

        Customer theCustomer = null; 

        if (result.isPresent()) {
            theCustomer = result.get();
        } else {
            throw new RuntimeException("Did not find customer id - " + customerId);
        }

        Order order = new Order();
        order.setCustomer(theCustomer);
        order.setOrderDate(new Date());

        for (OrderItem item : orderItems) {
            Product product = productRepository.findById(item.getProduct().getId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));
            item.setOrder(order);
            item.setProduct(product);
        }

        order.setOrderItems(orderItems);
        return orderRepository.save(order);
    }

    public OrderService(OrderRepository orderRepository, CustomerRepository customerRepository,
                        ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }
}
