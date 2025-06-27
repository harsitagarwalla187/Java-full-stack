package com.example.CollegeAdmissionManagement.repository;

import com.example.CollegeAdmissionManagement.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
