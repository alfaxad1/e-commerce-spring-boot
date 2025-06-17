package com.example.eCommerceApp.repository;

import com.example.eCommerceApp.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {
    @Query("SELECT o FROM Orders o JOIN o.customer c JOIN o.product p")
    List<Orders> getAllOrders();
}
