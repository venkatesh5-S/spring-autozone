package com.autozone.poc.exception;

public class ProductDetailsNotFoundException extends RuntimeException {


    public ProductDetailsNotFoundException(String message) {

        super(message);
    }


    public ProductDetailsNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductDetailsNotFoundException(Throwable cause) {
        super(cause);
    }


}
