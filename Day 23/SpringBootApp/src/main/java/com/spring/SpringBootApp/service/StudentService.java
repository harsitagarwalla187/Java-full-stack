package com.spring.SpringBootApp.service;

import com.spring.SpringBootApp.entity.Student;
import com.spring.SpringBootApp.repository.StudentRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository repo;

    public void removeStudent(Long studentId) {
        repo.removeStudent(studentId);
    }
}
