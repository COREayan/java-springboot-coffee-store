package com.coffee_store.starbucks.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coffee_store.starbucks.entity.Order;
import com.coffee_store.starbucks.entity.OrderItem;
import com.coffee_store.starbucks.service.OrderService;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/orders")
public class OrderController {
    
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/{customerId}")
    public Order placeOrder(@PathVariable int customerId, @RequestBody List<OrderItem> orderItems) {
        return orderService.placeOrder(customerId, orderItems);
    }
    
    
}
