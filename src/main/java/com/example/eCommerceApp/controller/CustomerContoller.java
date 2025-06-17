package com.example.eCommerceApp.controller;

import com.example.eCommerceApp.model.Customer;
import com.example.eCommerceApp.response.ResponseHandler;
import com.example.eCommerceApp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class CustomerContoller {
    @Autowired
    private CustomerService service;

    @RequestMapping("/customers")
    public ResponseEntity<Object> getCustomers(){
        List<Customer> customers = service.getCustomers();
        return ResponseHandler.responseBuilder("customers fetched successfully", HttpStatus.OK, customers);
    }

    @PostMapping("/customer")
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer){
        Customer customer1 = service.addCustomer(customer);
        return ResponseHandler.responseBuilder("customer added successfully", HttpStatus.CREATED, customer1);
    }

}
