package com.autozone.poc.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/product")
public class ProductDetailsController {



    @GetMapping(value = "/details")
    public String getProductDetails(){

        return "product details fetched successfully";
    }
}
