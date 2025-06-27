package com.example.CollegeAdmissionManagement.service;

import com.example.CollegeAdmissionManagement.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    private final String uploadDir = System.getProperty("user.dir") + "/target/classes/static/uploads";

    public void saveDocument(MultipartFile file) {

        try {

            File dir = new File(uploadDir);

        } catch (Exception e) {}

    }
}
