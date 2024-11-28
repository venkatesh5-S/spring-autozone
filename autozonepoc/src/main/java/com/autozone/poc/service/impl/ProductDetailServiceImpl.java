package com.autozone.poc.service.impl;

import com.autozone.poc.constants.Constants;
import com.autozone.poc.entity.ProductDetails;
import com.autozone.poc.entity.ProductDetailsNew;
import com.autozone.poc.exception.ProductDetailsNotFoundException;
import com.autozone.poc.mapper.ProductDetailsMapper;
import com.autozone.poc.repository.ProductDetailRepository;
import com.autozone.poc.repository.ProductDetailsNewRepository;
import com.autozone.poc.request.ProductDetailRequest;
import com.autozone.poc.response.ProductDetailResponseDto;
import com.autozone.poc.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductDetailServiceImpl implements ProductDetailService {

    @Autowired
    public ProductDetailsMapper productDetailsMapper;

    @Autowired
    public ProductDetailRepository productDetailRepository;

    @Autowired
    ProductDetailsNewRepository newRepository;

    @Override
    public List<ProductDetailResponseDto> getAllProductDetails() {
        return productDetailsMapper.transformListTo(productDetailRepository.findAll());
    }

    @Override
    public List<ProductDetailsNew> getAllProductDetailsNew() {
        return newRepository.findAll();
    }

    @Override
    public ProductDetailResponseDto addProdDetails(ProductDetailRequest productDetailRequest) {
        ProductDetails productDetails;
        try {
            productDetails = productDetailRepository.save(productDetailsMapper.transform(productDetailRequest));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return productDetailsMapper.transform(productDetails);
    }

    @Override
    public ProductDetailsNew addProdDetails(ProductDetailsNew productDetails) {
        return newRepository.save(productDetails);
    }

    @Override
    public ProductDetailResponseDto getProductDetailsById(Integer id) {
        Optional<ProductDetails> productDetails = productDetailRepository.findById(id);
        if (productDetails.isPresent()) {
            ProductDetails productDetails1 = productDetails.get();
            return productDetailsMapper.transform(productDetails1);
        } else {
            Exception e = new ProductDetailsNotFoundException(Constants.PRODUCT_DETAILS_NOT_FOUND_DESC);
            throw new ProductDetailsNotFoundException(e);
        }
    }

    @Override
    public ProductDetailResponseDto updateProductDetails(Integer id, ProductDetailRequest productDetailRequest) {
        Optional<ProductDetails> productDetails = productDetailRepository.findById(id);
        if (productDetails.isPresent()) {
            ProductDetails productDetails1 = productDetails.get();
            ProductDetails updatedProductDetails = productDetailsMapper.transform(productDetailRequest);
            updatedProductDetails.setPartID(id);
            productDetailRepository.save(updatedProductDetails);
            return productDetailsMapper.transform(updatedProductDetails);
        } else {
            Exception e = new ProductDetailsNotFoundException(Constants.PRODUCT_DETAILS_NOT_FOUND_DESC);
            throw new ProductDetailsNotFoundException(e);
        }
    }
}
