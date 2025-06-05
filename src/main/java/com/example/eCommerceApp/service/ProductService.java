package com.example.eCommerceApp.service;

import com.example.eCommerceApp.model.Product;
import com.example.eCommerceApp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repo;

    public List<Product> getAllProducts() {
       return repo.findAll();
    }

    public Product getProduct(int id){
        return repo.findById(id).get();
    }
}
