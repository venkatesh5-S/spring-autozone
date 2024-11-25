package com.autozone.poc.service.impl;

import com.autozone.poc.entity.ProductDetails;
import com.autozone.poc.mapper.ProductDetailsMapper;
import com.autozone.poc.repository.ProductDetailRepository;
import com.autozone.poc.request.ProductDetailRequest;
import com.autozone.poc.response.ProductDetailResponseDto;
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

    @Override
    public List<ProductDetailResponseDto> getAllProductDetails() {


        return productDetailsMapper.transformListTo(productDetailRepository.findAll());


    }

    @Override
    public String addProdDetails(ProductDetailRequest productDetailRequest) {

        productDetailRepository.save(productDetailsMapper.transform(productDetailRequest));

        return "SAVED SUCCESSFULLY";


    }

    @Override
    public ProductDetailResponseDto getProductDetailsById(Integer id) {


        Optional<ProductDetails> productDetails = productDetailRepository.findById(id);

        if (productDetails.isPresent()) {


            ProductDetails productDetails1 = productDetails.get();

            return productDetailsMapper.transform(productDetails1);
        } else {
            throw new RuntimeException();
        }

    }

    @Override
    public ProductDetailResponseDto updateProductDetails(Integer id, ProductDetailRequest productDetailRequest) {


        Optional<ProductDetails> productDetails = productDetailRepository.findById(id);


        if (productDetails.isPresent()) {
            ProductDetails productDetails1 = productDetails.get();
            ProductDetails updatedProductDetails = productDetailsMapper.transform(productDetailRequest);
            updatedProductDetails.setId(id);
            productDetailRepository.save(updatedProductDetails);

            return productDetailsMapper.transform(updatedProductDetails);


        } else {

            throw new RuntimeException();
        }
    }


}
