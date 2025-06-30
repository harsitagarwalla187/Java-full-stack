package com.example.StudentApi.repository;

import com.example.StudentApi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByRollNumber(String rollNumber);
    List<Student> findByNameContaining(String name);
}
