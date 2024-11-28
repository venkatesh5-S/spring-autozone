package com.autozone.poc.controller;


import com.autozone.poc.entity.ProductDetailsNew;
import com.autozone.poc.request.ProductDetailRequest;
import com.autozone.poc.response.ProductDetailResponseDto;
import com.autozone.poc.service.ProductDetailService;
import com.autozone.poc.service.impl.ProductDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductDetailsController {


    @Autowired
    ProductDetailService productDetailService;

    @Autowired
    ProductDetailServiceImpl productDetailServiceImpl;

    @GetMapping(value = "/details")
    public List<ProductDetailResponseDto> getProductDetailsOld() {
        return productDetailService.getAllProductDetails();
//        return productDetailService.getAllProductDetailsNew();
    }

    @GetMapping(value = "/details/get")
    public List<ProductDetailsNew> getProductDetails() {
//        return productDetailService.getAllProductDetails();
        return productDetailService.getAllProductDetailsNew();
    }

    @PostMapping(value = "/details")
    public ProductDetailResponseDto addProdDetails(@RequestBody ProductDetailRequest productDetailRequest) {
            return productDetailService.addProdDetails(productDetailRequest);
    }

    @PostMapping(value = "/details/post")
    public ProductDetailsNew addProdDetailsNew(@RequestBody ProductDetailsNew productDetails) {
        return productDetailService.addProdDetails(productDetails);
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
