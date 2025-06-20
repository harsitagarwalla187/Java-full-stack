package com.spring.SpringBootApp.service;

import com.spring.SpringBootApp.entity.Course;
import com.spring.SpringBootApp.entity.Student;
import com.spring.SpringBootApp.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepository repo;

    public void addCourseWithStudents(Course course) {
        repo.addCourseWithStudents(course);
    }

    public void enrollStudentToCourse(long studentId, long courseId) {
        repo.enrollStudentToCourse(studentId, courseId);
    }

    public void  getAllCoursesWithStudentCount() {
        repo.getAllCoursesWithStudentCount();
    }

    public void  getTop3CoursesByEnrollment() {
        repo.getTop3CoursesByEnrollment();
    }
}
