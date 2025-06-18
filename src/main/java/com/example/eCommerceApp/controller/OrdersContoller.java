package com.example.eCommerceApp.controller;

import com.example.eCommerceApp.model.Orders;
import com.example.eCommerceApp.repository.OrderRepository;
import com.example.eCommerceApp.response.ResponseHandler;
import com.example.eCommerceApp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class OrdersContoller {
    @Autowired
    private OrderService service;

    @Autowired
    private OrderRepository repo;

    @RequestMapping("/orders")
    public ResponseEntity<Object> getAllOrders() {
        List<?> orders = repo.getAllOrders();
        return ResponseHandler.responseBuilder("orders fetched successfully", HttpStatus.OK, orders);
    }

    @RequestMapping("/order/{id}")
    public ResponseEntity<Object> getOrders(@PathVariable Integer id) {
        List<Orders> orders = repo.getOrdersByCustomerId(id);
        if (orders != null)
            return ResponseHandler.responseBuilder("orders fetched successfully", HttpStatus.OK, orders);
        else
            return ResponseHandler.responseBuilder("orders not found", HttpStatus.NOT_FOUND, null);
    }

    @PostMapping("/orders")
    public ResponseEntity<?> createOrder(@RequestBody Orders order) {
        Orders order1 = service.createOrder(order);
        return ResponseHandler.responseBuilder("order created successfully", HttpStatus.CREATED, order1);
    }
}
