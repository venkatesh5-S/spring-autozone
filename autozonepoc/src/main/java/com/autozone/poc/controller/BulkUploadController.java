package com.autozone.poc.controller;

import com.autozone.poc.service.BulkUploadService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("product")
@Log
public class BulkUploadController {

    @Autowired
    BulkUploadService bulkUploadService;

    @PostMapping("/bulkUpload")
    public ResponseEntity<String> bulkUploadFromExcel(@RequestParam("file") MultipartFile file) throws IOException {
        log.info("Calling Bulk Upload form excel call");
        return bulkUploadService.processExcel(file);

    }
}
