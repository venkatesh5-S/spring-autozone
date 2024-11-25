package com.autozone.poc.controller;


import com.autozone.poc.exception.ProductDetailsNotFoundException;
import com.autozone.poc.response.ExceptionResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GenericControllerAdvice {


    @ExceptionHandler(value = ProductDetailsNotFoundException.class)
    public ResponseEntity<Object> productDetailsNotFoundException(ProductDetailsNotFoundException exception) {

        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto();
        exceptionResponseDto.setStatusCode(HttpStatus.NOT_FOUND.value());
        Throwable cause = exception.getCause();
        String message = null;
        if (cause != null) {
            message = cause.getMessage();
        }
        exceptionResponseDto.setCause(message);
        exceptionResponseDto.setStatusDescription(HttpStatus.NOT_FOUND.getReasonPhrase());
        return new ResponseEntity<>(exceptionResponseDto, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<Object> productDetailsNotFoundException(RuntimeException exception) {

        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto();
        exceptionResponseDto.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        Throwable cause = exception.getCause();
        String message = null;
        if (cause != null) {
            message = cause.getMessage();
        }
        exceptionResponseDto.setCause(message);
        exceptionResponseDto.setStatusDescription(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        return new ResponseEntity<>(exceptionResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> productDetailsNotFoundException(Exception exception) {

        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto();
        exceptionResponseDto.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        Throwable cause = exception.getCause();
        String message = null;
        if (cause != null) {
            message = cause.getMessage();
        }
        exceptionResponseDto.setCause(message);
        exceptionResponseDto.setStatusDescription(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        return new ResponseEntity<>(exceptionResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);

    }






}
