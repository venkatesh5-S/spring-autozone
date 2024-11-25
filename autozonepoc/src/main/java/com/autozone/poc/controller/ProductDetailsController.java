package com.autozone.poc.controller;


import com.autozone.poc.request.ProductDetailRequest;
import com.autozone.poc.response.ProductDetailResponseDto;
import com.autozone.poc.service.impl.ProductDetailService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductDetailsController {


    @Autowired
    ProductDetailService productDetailService;

    @GetMapping(value = "/details")
    public List<ProductDetailResponseDto> getProductDetails() {

        return productDetailService.getAllProductDetails();
    }

    @PostMapping(value = "/details")
    public String addProdDetails(@RequestBody ProductDetailRequest productDetailRequest) {

        return productDetailService.addProdDetails(productDetailRequest);

    }




    @GetMapping(value="/details/{id}")
    public ProductDetailResponseDto getProductDetailsById(@PathVariable Integer id){


     return    productDetailService.getProductDetailsById(id);
    }


    @PutMapping("/details/{id}")

    public ProductDetailResponseDto updateProductDetailsById(@PathVariable Integer id, @RequestBody ProductDetailRequest productDetailRequest){


       return      productDetailService.updateProductDetails(id,productDetailRequest);

    }



}
