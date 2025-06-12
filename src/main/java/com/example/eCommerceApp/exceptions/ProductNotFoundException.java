package com.example.eCommerceApp.exceptions;


public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String cause) {
        super(cause);
    }

    public ProductNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
