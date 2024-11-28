package com.autozone.poc.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface BulkUploadService {

    public ResponseEntity<String> processExcel(MultipartFile file) throws IOException;
}
