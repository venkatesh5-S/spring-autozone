package com.autozone.poc.entity;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="Product_Details")
public class ProductDetails {


    @Id
    @SequenceGenerator(name="id",sequenceName = "products_details_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id")
    @Column(name = "partid", length = 100)
    private Integer partID;

    @Column(name = "partname", length = 100)
    private String partName;

    @Column(name = "partdescription", length = 100)
    private String partDescription;

    @Column(name = "category", length = 100)
    private String category;

    @Column(name = "brandname", length = 100)
    private String brandName;

    @Column(name = "compatibility", length = 100)
    private String compatibility;

    @Column(name = "material", length = 100)
    private String material;

    @Column(name = "dimensions", length = 100)
    private String dimensions;
    @Column(name = "warrantyperiod")
    private Integer warrantyPeriod;

    @Column(name = "suppliername", length = 100)
    private String supplierName;

    @Column(name = "unitprice", precision = 10, scale = 4)
    private BigDecimal unitPrice;

    @Column(name = "stockvalue", precision = 10, scale = 4)
    private BigDecimal stockValue;

    @Column(name = "restockleadtime")
    private Integer restockLeadTime;

    @Column(name = "leadtimevariability", length = 100)
    private String leadTimeVariability;

    @Column(name = "batchnumber", length = 100)
    private String batchNumber;

    @Column(name = "expirydate")
    private LocalDate expiryDate;

    @Column(name = "storageconditions", length = 100)
    private String storageConditions;

    @Column(name = "locationinwarehouse", length = 100)
    private String locationInWarehouse;

    @Column(name = "lastrestockeddate")
    private LocalDateTime lastRestockedDate;

    @Column(name = "daysininventory")
    private Integer daysInInventory;

    @Column(name="image")
    private String image;
}
