package com.myapp;

import com.myapp.config.AppConfig;
import com.myapp.model.Department;
import com.myapp.model.Employee;
import com.myapp.service.DepartmentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class App
{
    public static void main( String[] args ) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        DepartmentService service = context.getBean(DepartmentService.class);

        System.out.println("--- Welcome to Employee Management System. ---");

        boolean flag = true;
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("Select One Option Only :-");
            System.out.println("1. Add Department with Employees");
            System.out.println("2. List All Departments with Their Employees");
            System.out.println("3. Add Employee to Existing Department");
            System.out.println("4. Remove an Employee");
            System.out.println("5. Delete a Department");
            System.out.println("6. Exit");
            System.out.print("Enter the option: ");
            int userInput = scan.nextInt();
            scan.nextLine();

            switch(userInput) {
                case 1:
                    System.out.println("--- Add Department with Employees ---");
                    Department newDepart = new Department();
                    System.out.print("Enter Department Name: ");
                    newDepart.setDepartmentName(scan.nextLine());
                    System.out.print("Enter no. of employee: ");
                    int numOfEmp = scan.nextInt();
                    scan.nextLine();
                    for(int i=0; i<numOfEmp; i++) {
                        System.out.print("Employee " + i + " details...\n");
                        System.out.print("Enter Employee Name: ");
                        String name = scan.nextLine();
                        System.out.print("Enter Employee Salary: ");
                        Double salary = scan.nextDouble();
                        scan.nextLine();
                        Employee newEmp = new Employee();
                        newEmp.setName(name);
                        newEmp.setSalary(salary);
                        newDepart.addEmployee(newEmp);
                    }
                    service.addDepartment(newDepart);
                    break;
                case 2:
                    System.out.println("--- List All Departments with Their Employees ---");
                    service.showAllDepartmentAndEmployees();
                    break;
                case 3:
                    System.out.println("--- Add Employee to Existing Department ---");
                    System.out.print("Enter Employee Department ID: ");
                    long departmentId = scan.nextLong();
                    scan.nextLine();
                    Employee newEmp = new Employee();
                    System.out.print("Enter Employee Name: ");
                    newEmp.setName(scan.nextLine());
                    System.out.print("Enter Employee Salary: ");
                    newEmp.setSalary(scan.nextDouble());
                    scan.nextLine();
                    service.addEmployee(departmentId, newEmp);
                    break;
                case 4:
                    System.out.println("--- Remove an Employee ---");
                    System.out.print("Enter Department ID: ");
                    long dId = scan.nextLong();
                    System.out.print("Enter Employee ID: ");
                    long eId = scan.nextLong();
                    scan.nextLine();
                    service.removeEmployee(dId, eId);
                    break;
                case 5:
                    System.out.println("--- Delete a Department ---");
                    System.out.print("Enter Department ID: ");
                    long id = scan.nextLong();
                    scan.nextLine();
                    service.removeDepartment(id);
                    break;
                case 6:
                    flag = false;
                    break;
                default:
                    System.out.println("Do you want to continue?(Y/N)");
                    char ch = scan.nextLine().charAt(0);
                    flag = (ch == 'Y' || ch == 'y');
            }
        } while(flag);

        System.out.println("--- Application closed successfully. ---");

    }
}
