package com.example.eCommerceApp.service;

import com.example.eCommerceApp.model.Customer;
import com.example.eCommerceApp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repo;

    public List<Customer> getCustomers() {
        return repo.findAll();
    }

    public Customer addCustomer(Customer customer) {
        return repo.save(customer);
    }
}
