package com.autozone.poc.mapper;


import com.autozone.poc.entity.ProductDetails;
import com.autozone.poc.mapper.decorator.ProductDetailsDecorator;
import com.autozone.poc.request.ProductDetailRequest;
import com.autozone.poc.response.ProductDetailResponseDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@DecoratedWith(value= ProductDetailsDecorator.class)
@Mapper(componentModel = "spring")
public interface ProductDetailsMapper {


    ProductDetailResponseDto transform(ProductDetails productDetails);








    ProductDetails transform(ProductDetailRequest productDetailRequest);


    default List<ProductDetailResponseDto> transformListTo(List<ProductDetails> list){


        return list.stream().map(productDetails->this.transform(productDetails)).collect(Collectors.toList());

    }

}
