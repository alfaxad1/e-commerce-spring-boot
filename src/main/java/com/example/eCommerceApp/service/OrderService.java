package com.example.eCommerceApp.service;

import com.example.eCommerceApp.model.Orders;
import com.example.eCommerceApp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repo;

    public Orders createOrder(Orders order) {
        return repo.save(order);
    }

    public List<Orders> getOrders() {
        return repo.findAll();
    }
}
