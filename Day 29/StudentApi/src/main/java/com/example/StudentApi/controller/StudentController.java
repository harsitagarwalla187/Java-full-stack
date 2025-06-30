package com.example.StudentApi.controller;

import com.example.StudentApi.model.Student;
import com.example.StudentApi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        if(students.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        return ResponseEntity.ok(students);
    }

    @PostMapping("/students")
    public void saveStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id) {
        Student student = studentService.getStudentById(id).get();
        return ResponseEntity.ok(student);
    }

    @PutMapping("/students/{id}")
    public void updateStudent(@PathVariable("id") Long id, @RequestBody Student student) {
        student.setId(id);
        studentService.saveStudent(student);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
    }

//    @GetMapping("/students/searchByName")
//    public ResponseEntity<List<Student>> searchStudentByName(@RequestParam("name") String name) {
//        List<Student> students = studentService.searchByName(name);
//        if(students.isEmpty())
//            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//        return ResponseEntity.ok(students);
//    }
//
//    @GetMapping("/students/searchByRollNumber")
//    public ResponseEntity<Student> searchStudentByRollNumber(@RequestParam("rollNumber") String rollNumber) {
//        Student student = studentService.getStudentByRollNumber(rollNumber);
//        if(student == null)
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        return ResponseEntity.ok(student);
//    }

    @GetMapping("/students/search")
    public ResponseEntity<?> searchStudent(@RequestParam(required = false, value = "name") String name, @RequestParam(required = false, value = "rollNumber") String rollNumber) {
        if(rollNumber == null) {
            List<Student> students = studentService.searchByName(name);
            if(students.isEmpty())
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            return ResponseEntity.ok(students);
        } else {
            Student student = studentService.getStudentByRollNumber(rollNumber);
            if(student == null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            return ResponseEntity.ok(student);
        }
    }
}
