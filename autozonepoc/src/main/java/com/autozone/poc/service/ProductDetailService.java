package com.autozone.poc.service;

import com.autozone.poc.entity.ProductDetailsNew;
import com.autozone.poc.request.ProductDetailRequest;
import com.autozone.poc.response.ProductDetailResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductDetailService {

    public List<ProductDetailsNew> getAllProductDetailsNew();
    public List<ProductDetailResponseDto> getAllProductDetails();
    public ProductDetailResponseDto addProdDetails(ProductDetailRequest productDetailRequest);
    public ProductDetailResponseDto getProductDetailsById(Integer id);
    public ProductDetailResponseDto updateProductDetails(Integer  id,ProductDetailRequest productDetailRequest);
    ProductDetailsNew addProdDetails(ProductDetailsNew productDetails);
}
