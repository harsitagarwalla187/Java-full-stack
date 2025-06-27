package com.example.CollegeAdmissionManagement.repository;

import com.example.CollegeAdmissionManagement.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}
