package com.autozone.poc.mapper;


import com.autozone.poc.entity.ProductDetails;
import com.autozone.poc.mapper.decorator.ProductDetailsDecorator;
import com.autozone.poc.request.ProductDetailRequest;
import com.autozone.poc.response.ProductDetailResponseDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@DecoratedWith(value= ProductDetailsDecorator.class)
@Mapper(componentModel = "spring")
public interface ProductDetailsMapper {


    ProductDetailResponseDto transform(ProductDetails productDetails);







    @Mapping(target = "material", defaultValue = "steel")
    @Mapping(target = "dimensions", defaultValue = "10\\\"X10\\\"X10\\\"")
    @Mapping(target = "restockLeadTime", defaultValue = "1")
    @Mapping(target = "batchNumber", defaultValue = "B0001")
    @Mapping(target = "expiryDate", expression = "java(handleDefaultExpiryDate(productDetailRequest.getExpiryDate()))")
    @Mapping(target = "storageConditions", defaultValue = "Cool, Dry")
    @Mapping(target = "locationInWarehouse", defaultValue = "Aisle 2, Shelf B")
    @Mapping(target = "daysInInventory", defaultValue = "5")
    @Mapping(target = "lastRestockedDate", expression = "java(handleDefaultLastRestockedDate(productDetailRequest.getLastRestockedDate()))")

    ProductDetails transform(ProductDetailRequest productDetailRequest);


    default List<ProductDetailResponseDto> transformListTo(List<ProductDetails> list){


        return list.stream().map(productDetails->this.transform(productDetails)).collect(Collectors.toList());

    }

    // Utility methods to handle default logic
    default java.time.LocalDate handleDefaultExpiryDate(java.time.LocalDate expiryDate) {
        return expiryDate != null ? expiryDate : java.time.LocalDate.parse("9999-12-31");
    }

    default java.time.LocalDateTime handleDefaultLastRestockedDate(java.time.LocalDateTime lastRestockedDate) {
        return lastRestockedDate != null ? lastRestockedDate : java.time.LocalDateTime.parse("2024-11-18T00:00:00");
    }

}
