package com.autozone.poc.response;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ProductDetailResponseDto {




    public String partID;


    public String partName;


    public String partDescription;


    public String category;


    public String brandName;


    public String compatibility;

    public String material;


    public String dimensions;

    public Integer warrantyPeriod;


    public String supplierName;


    public BigDecimal unitPrice;


    public BigDecimal stockValue;


    public Integer restockLeadTime;


    public String leadTimeVariability;


    public String batchNumber;


    public LocalDate expiryDate;


    public String storageConditions;


    public String locationInWarehouse;


    public LocalDateTime lastRestockedDate;


    public Integer daysInInventory;

}
