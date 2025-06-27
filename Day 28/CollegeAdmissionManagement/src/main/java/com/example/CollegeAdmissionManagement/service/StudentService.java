package com.example.CollegeAdmissionManagement.service;

import com.example.CollegeAdmissionManagement.model.Student;
import com.example.CollegeAdmissionManagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }
}
