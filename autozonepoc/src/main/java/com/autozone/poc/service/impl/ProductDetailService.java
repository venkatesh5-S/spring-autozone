package com.autozone.poc.service.impl;

import com.autozone.poc.request.ProductDetailRequest;
import com.autozone.poc.response.ProductDetailResponseDto;

import java.util.List;

public interface ProductDetailService {



    public List<ProductDetailResponseDto> getAllProductDetails();


    public String addProdDetails(ProductDetailRequest productDetailRequest);


    public ProductDetailResponseDto getProductDetailsById(Integer id);


    public ProductDetailResponseDto updateProductDetails(Integer id,ProductDetailRequest productDetailRequest);
}
