package com.example.eCommerceApp.controller;

import java.util.List;

import com.example.eCommerceApp.response.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.eCommerceApp.model.Product;
import com.example.eCommerceApp.service.ProductService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductService service;

    @RequestMapping("/")
    public String greet() {
        return "Hello world";
    }

    @RequestMapping("/products")
    public ResponseEntity<Object> getAllProducts() {
        List<Product> product = service.getAllProducts();

        if (product != null && !product.isEmpty())
            return ResponseHandler.responseBuilder("Products fetched successfully", HttpStatus.OK, product);

        else
            return ResponseHandler.responseBuilder("no product found", HttpStatus.NOT_FOUND, null);
    }

    @RequestMapping("/product/{id}")
    public ResponseEntity<Object> getProduct(@PathVariable int id) {
        return ResponseHandler.responseBuilder("product found", HttpStatus.OK, service.getProduct(id));
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        try {
            Product product1 = service.addProduct(product);
            return ResponseHandler.responseBuilder("product added successfully", HttpStatus.OK, product1);
        } catch (Exception e) {
            return ResponseHandler.responseBuilder("error creating product", HttpStatus.INTERNAL_SERVER_ERROR,
                    e.getMessage());
        }
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable int id, @RequestBody Product product) {
        Product prod = service.getProduct(id);

        if (prod != null) {
            product.setId(id);
            Product product1 = service.updateProduct(id, product);

            if (product1 != null && !product1.isAvailable())
                return ResponseHandler.responseBuilder("Updated successfully", HttpStatus.OK, product1);

            else
                return ResponseHandler.responseBuilder("Failed to update", HttpStatus.BAD_REQUEST, null);

        } else {
            return ResponseHandler.responseBuilder("Product not found", HttpStatus.NOT_FOUND, null);
        }
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable int id) {
        Product prod = service.getProduct(id);

        if (prod != null) {
            service.deleteProduct(id);
            return ResponseHandler.responseBuilder("Deleted", HttpStatus.OK, prod);

        } else
            return ResponseHandler.responseBuilder("Product not found", HttpStatus.NOT_FOUND, null);
    }

    @GetMapping("/product/brand/{brand}")
    public ResponseEntity<Object> getBrand(@PathVariable String brand) {
        List<Product> products = service.getBrand(brand);

        if (products != null && !products.isEmpty()) {
            return ResponseHandler.responseBuilder("Products fetched successfully", HttpStatus.OK, products);
        } else {
            return ResponseHandler.responseBuilder("No products found for the specified brand", HttpStatus.NOT_FOUND,
                    null);
        }
    }
}
