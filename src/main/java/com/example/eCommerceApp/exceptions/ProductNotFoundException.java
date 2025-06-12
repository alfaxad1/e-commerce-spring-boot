package com.example.eCommerceApp.exceptions;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(Throwable cause) {
        super(cause);
    }

    public ProductNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
