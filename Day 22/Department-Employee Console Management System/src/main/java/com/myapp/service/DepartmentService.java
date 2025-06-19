package com.myapp.service;

import com.myapp.model.Department;
import com.myapp.model.Employee;
import com.myapp.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository dRepo;

    public void addDepartment(Department department) {
        dRepo.addDepartment(department);
    }

    public void showAllDepartmentAndEmployees() {
        List<Department> all = dRepo.showAllDepartmentAndEmployees();
        for(Department i: all) {
            System.out.println("---------------------------------");
            System.out.println("---------------------------------");
            System.out.println("Department ID: " + i.getId());
            System.out.println("Department: " + i.getDepartmentName());
            System.out.println("---------------------------------");
            System.out.println("---------------------------------");
            for(Employee j: i.getEmployees()) {
                System.out.println("Employee ID: " + j.getId());
                System.out.println("Employee Name: " + j.getName());
                System.out.println("Employee Salary: " + j.getSalary());
                System.out.println("---------------------------------");
            }
        }
    }

    public void addEmployee(long departmentId, Employee newEmployee) {
        dRepo.addEmployee(departmentId, newEmployee);
    }

    public void removeEmployee(long departmentId, long employeeId) {
        dRepo.removeEmployee(departmentId, employeeId);
    }

    public void removeDepartment(long departmentId) {
        dRepo.removeDepartment(departmentId);
    }
}
