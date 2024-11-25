package com.autozone.poc.controller;


import com.autozone.poc.exception.ProductDetailsNotFoundException;
import com.autozone.poc.request.ProductDetailRequest;
import com.autozone.poc.response.ProductDetailResponseDto;
import com.autozone.poc.service.impl.ProductDetailService;
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
    public ProductDetailResponseDto addProdDetails(@RequestBody ProductDetailRequest productDetailRequest) {




//        try {

            return productDetailService.addProdDetails(productDetailRequest);

//        }
//        catch (Exception e){
//            handleException(e);
//        }


    }




    @GetMapping(value="/details/{id}")
    public ProductDetailResponseDto getProductDetailsById(@PathVariable Integer id) {

//        try {
            return productDetailService.getProductDetailsById(id);
//        }

//        catch (Exception e){
//
//        handleException(e);
//
//        }
//        return null;
    }


    @PutMapping("/details/{id}")

    public ProductDetailResponseDto updateProductDetailsById(@PathVariable Integer id, @RequestBody ProductDetailRequest productDetailRequest){


       return      productDetailService.updateProductDetails(id,productDetailRequest);

    }


//    public void handleException( Exception e){
//
//
//
//        if( e instanceof ProductDetailsNotFoundException){
//            throw new ProductDetailsNotFoundException(e);
//        }
//    }






}
