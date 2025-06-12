package com.example.eCommerceApp.service;

import java.util.List;

import com.example.eCommerceApp.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.example.eCommerceApp.model.Product;
import com.example.eCommerceApp.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repo;

    //get all products
    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    //get a product by id
    public Product getProduct(int id) {
        if(repo.findById(id).isEmpty())
            throw new ProductNotFoundException("Product doesn't exist");

        return repo.findById(id).get();
    }

    //create a product
    public Product addProduct(Product product) {
        return repo.save(product);
    }

    //update a product
    public Product updateProduct(int id, Product product) {
        Product existingProduct = repo.findById(id).orElse(null);
        if (existingProduct == null) {
            return null;
        }
        existingProduct.setAvailable(product.isAvailable());
        existingProduct.setName(product.getName());
        existingProduct.setBrand(product.getBrand());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setCategory(product.getCategory());

        return repo.save(existingProduct);
    }

    //delete a product
    public void deleteProduct(int id) {
        repo.deleteById(id);
    }

    //get brand

}
