package com.example.CollegeAdmissionManagement.service;

import com.example.CollegeAdmissionManagement.model.Course;
import com.example.CollegeAdmissionManagement.model.Student;
import com.example.CollegeAdmissionManagement.repository.CourseRepository;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
