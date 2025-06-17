package com.example.eCommerceApp.controller;

import com.example.eCommerceApp.repository.OrderRepository;
import com.example.eCommerceApp.response.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class OrdersContoller {
    @Autowired
    OrderRepository repo;

    @RequestMapping("/orders")
    public ResponseEntity<Object> getAllOrders(){
        List<?> orders = repo.getAllOrders();
        return ResponseHandler.responseBuilder("orders fetched successfully", HttpStatus.OK, orders);
    }
}
