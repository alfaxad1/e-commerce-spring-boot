package com.example.eCommerceApp.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Data
public class ProductException {
    private final String message;
    private final Throwable cause;
    private final HttpStatus httpStatus;
}
