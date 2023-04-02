package com.osorio.supermarket.exception;

public class ProductNoFoundException extends RuntimeException{
    public ProductNoFoundException(String message) {
        super(message);
    }
}
