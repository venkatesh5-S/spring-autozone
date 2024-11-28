package com.autozone.poc.service.impl;

import com.autozone.poc.entity.ProductDetails;
import com.autozone.poc.entity.ProductDetailsNew;
import com.autozone.poc.repository.ProductDetailRepository;
import com.autozone.poc.repository.ProductDetailsNewRepository;
import com.autozone.poc.service.BulkUploadService;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BulkUploadServiceImpl implements BulkUploadService {

    private static final Logger log = LoggerFactory.getLogger(BulkUploadServiceImpl.class);
    @Autowired
    ProductDetailsNewRepository repository;

    @Autowired
    ProductDetailRepository productDetailRepository;

    @Override
    public ResponseEntity<String> processExcel(MultipartFile file) throws IOException {
        boolean extension = FilenameUtils.isExtension(file.getOriginalFilename(), Arrays.asList("xlsx", "xls"));
        if(file.isEmpty() || !extension){
            log.error("Please Upload a excel file");
            return new ResponseEntity<>("Please Upload a excel file", HttpStatus.BAD_REQUEST);
        }
        List<ProductDetailsNew> allProducts = new ArrayList<>();
        try(InputStream inputStream = file.getInputStream();
            Workbook workbook = WorkbookFactory.create(inputStream)){
            Sheet sheet = workbook.getSheetAt(0);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            for(int i=1;i<sheet.getLastRowNum();i++){
                Row row = sheet.getRow(i);
                ProductDetailsNew productDetailsNew = new ProductDetailsNew();
//                ProductDetails productDetails = new ProductDetails();
//                productDetailsNew.setPartId(row.getCell(0).getStringCellValue());
                productDetailsNew.setPartName(row.getCell(1).getStringCellValue());
                productDetailsNew.setPartDescription(row.getCell(2).getStringCellValue());
                productDetailsNew.setCategory(row.getCell(3).getStringCellValue());
                productDetailsNew.setBrandName(row.getCell(4).getStringCellValue());
                productDetailsNew.setCompatibility(row.getCell(5).getStringCellValue());
                productDetailsNew.setMaterial(row.getCell(6).getStringCellValue());
                productDetailsNew.setDimensions(row.getCell(7).getStringCellValue());
                productDetailsNew.setWarrantyPeriod((int)row.getCell(8).getNumericCellValue());
                productDetailsNew.setSupplierName(row.getCell(9).getStringCellValue());
//                productDetailsNew.setLastRestockedDate(LocalDateTime.parse(row.getCell(10).getStringCellValue(),formatter));
                productDetailsNew.setLastRestockedDate(String.valueOf(row.getCell(10).getNumericCellValue()));
                productDetailsNew.setDaysInInventory((int)row.getCell(11).getNumericCellValue());
                productDetailsNew.setManufacturer(row.getCell(12).getStringCellValue());
                productDetailsNew.setLocation(row.getCell(13).getStringCellValue());
                productDetailsNew.setWarehouse(row.getCell(14).getStringCellValue());
//                productDetailsNew.setManufacturedDate(LocalDateTime.parse(row.getCell(14).getStringCellValue(),formatter));
                productDetailsNew.setManufacturedDate(String.valueOf(row.getCell(15).getNumericCellValue()));
                productDetailsNew.setAgeOfCar((int)row.getCell(16).getNumericCellValue());
                productDetailsNew.setNumberOfCarsOnRoad((int)row.getCell(17).getNumericCellValue());
                productDetailsNew.setUnitPrice(BigDecimal.valueOf(row.getCell(18).getNumericCellValue()));
                productDetailsNew.setStockValue(BigDecimal.valueOf(row.getCell(19).getNumericCellValue()));
                productDetailsNew.setLeadTimeVariability(row.getCell(20).getStringCellValue());

                allProducts.add(productDetailsNew);
            }
            repository.saveAll(allProducts);
            log.info("Products uploaded successfully");
            return new ResponseEntity<>("Products uploaded successfully", HttpStatus.OK);
        } catch(Exception e){
            log.error("Failed to upload products");
            e.printStackTrace();
            return new ResponseEntity<>("Failed to upload products:"+e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
