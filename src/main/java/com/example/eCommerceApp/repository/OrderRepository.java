package com.example.eCommerceApp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.eCommerceApp.model.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {
    @Query("SELECT o FROM Orders o JOIN o.customer c JOIN o.product p")
    List<Orders> getAllOrders();

    @Query(value = "SELECT * FROM orders WHERE customer_id = :id", nativeQuery = true)
    List<Orders> getOrdersByCustomerId(@Param("id") Integer id);
}
