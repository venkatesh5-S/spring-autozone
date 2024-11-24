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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "PartID", length = 100)
    private String partID;

    @Column(name = "PartName", length = 100)
    private String partName;

    @Column(name = "PartDescription", length = 100)
    private String partDescription;

    @Column(name = "Category", length = 100)
    private String category;

    @Column(name = "BrandName", length = 100)
    private String brandName;

    @Column(name = "Compatibility", length = 100)
    private String compatibility;

    @Column(name = "Material", length = 100)
    private String material;

    @Column(name = "Dimensions", length = 100)
    private String dimensions;
    @Column(name = "WarrantyPeriod")
    private Integer warrantyPeriod;

    @Column(name = "SupplierName", length = 100)
    private String supplierName;

    @Column(name = "UnitPrice", precision = 10, scale = 4)
    private BigDecimal unitPrice;

    @Column(name = "StockValue", precision = 10, scale = 4)
    private BigDecimal stockValue;

    @Column(name = "RestockLeadTime")
    private Integer restockLeadTime;

    @Column(name = "LeadTimeVariability", length = 100)
    private String leadTimeVariability;

    @Column(name = "BatchNumber", length = 100)
    private String batchNumber;

    @Column(name = "ExpiryDate")
    private LocalDate expiryDate;

    @Column(name = "StorageConditions", length = 100)
    private String storageConditions;

    @Column(name = "LocationInWarehouse", length = 100)
    private String locationInWarehouse;

    @Column(name = "LastRestockedDate")
    private LocalDateTime lastRestockedDate;

    @Column(name = "DaysInInventory")
    private Integer daysInInventory;

}
