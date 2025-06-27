package com.example.CollegeAdmissionManagement.repository;

import com.example.CollegeAdmissionManagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
