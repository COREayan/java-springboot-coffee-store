package com.coffee_store.rest;

import com.coffee_store.entity.Order;
import com.coffee_store.entity.OrderItem;
import com.coffee_store.service.OrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/orders")
public class OrderController {
    
    private final OrderService orderService;

    @PostMapping("/{customerId}")
    public Order placeOrder(@PathVariable int customerId, @RequestBody List<OrderItem> orderItems) {
        return orderService.placeOrder(customerId, orderItems);
    }

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
}
