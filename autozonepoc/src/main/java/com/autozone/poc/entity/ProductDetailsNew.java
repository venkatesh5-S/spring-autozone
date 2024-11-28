package com.autozone.poc.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "product_details_new")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class ProductDetailsNew {

    @Column(name="Part_ID")
    @Id
    @SequenceGenerator(name="id",sequenceName = "products_details_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id")
    private Long partId;
    @Column(name="Part_Name")
    private String partName;
    @Column(name="Part_Description")
    private String partDescription;
    @Column(name="Category")
    private String category;
    @Column(name="Brand_Name")
    private String brandName;
    @Column(name="Compatibility")
    private String compatibility;
    @Column(name="Material")
    private String material = "Steel";
    @Column(name="Dimensions")
    private String dimensions="10x10x10 inch";
    @Column(name="Warranty_Period")
    private int warrantyPeriod;
    @Column(name="Supplier_Name")
    private String supplierName;
    @Column(name="Last_Restocked_Date")
    private String lastRestockedDate;
    @Column(name="Days_in_Inventory")
    private int daysInInventory;
    @Column(name="Manufacturer")
    @JsonProperty(value="manufacturer")
    private String manufacturer;
    @Column(name="Location")
    private String location;
    @Column(name="Warehouse")
    private String warehouse;
    @Column(name="Manufactured Date")
    private String manufacturedDate;
    @Column(name="Age_of_Car")
    private int ageOfCar;
    @Column(name="Number_of_Cars_on_Road")
    private int numberOfCarsOnRoad;
    @Column(name="Unit_Price")
    private BigDecimal unitPrice;
    @Column(name="Stock_Value")
    private BigDecimal stockValue;
    @Column(name="Lead_Time_Variability")
    private String leadTimeVariability;
    @Column(name="image")
    private String image;

}
