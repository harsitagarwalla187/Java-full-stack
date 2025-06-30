package com.example.StudentApi.controller;

import com.example.StudentApi.model.Employee;
import com.example.StudentApi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public ResponseEntity<List<Employee>> getAllStudents() {
        List<Employee> employees = employeeService.getAllStudents();
        if(employees.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        return ResponseEntity.ok(employees);
    }

    @PostMapping("/students")
    public void saveStudent(@RequestBody Employee employee) {
        employeeService.saveStudent(employee);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Employee> getStudentById(@PathVariable("id") Long id) {
        Employee employee = employeeService.getStudentById(id).get();
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/students/{id}")
    public void updateStudent(@PathVariable("id") Long id, @RequestBody Employee employee) {
        employee.setId(id);
        employeeService.saveStudent(employee);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable("id") Long id) {
        employeeService.deleteStudent(id);
    }

    @GetMapping("/students/searchByName")
    public ResponseEntity<List<Employee>> searchStudentByName(@RequestParam("name") String name) {
        List<Employee> employees = employeeService.searchByName(name);
        if(employees.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/students/searchByRollNumber")
    public ResponseEntity<Employee> searchStudentByRollNumber(@RequestParam("rollNumber") String rollNumber) {
        Employee employee = employeeService.getStudentByRollNumber(rollNumber);
        if(employee == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(employee);
    }
}
