package com.employeemanagement.app.defination;

import com.employeemanagement.app.entity.Employee;
import com.employeemanagement.app.utility.Sessions;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeHandler {
    Session session;
    Scanner scan;

    public EmployeeHandler() {
        Sessions sessions = new Sessions();
        session = sessions.getSession();
        scan = new Scanner(System.in);
    }

    public void addEmployee() {

        Employee em = new Employee();
        Transaction tx = session.beginTransaction();

        System.out.println("Enter Employee Details to add :-");
        System.out.print("Enter Name: ");
        em.setName(scan.nextLine());

        boolean email = false;
        do {
            System.out.print("Enter " + (email ? "correct" : "")  + " email: ");
            em.setEmail(scan.nextLine());
            email = true;
        } while (!isValidEmail(em.getEmail()));

        System.out.print("Enter Designation: ");
        em.setDesignation(scan.nextLine());
        System.out.print("Enter Salary: ");
        em.setSalary(scan.nextDouble());

        session.persist(em);
        tx.commit();

        System.out.println("Employee Added Successfully!");
    }

    private boolean isValidEmail(String email) {
        String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public void showEmployees() {
        Query<Employee> query = session.createQuery("FROM Employee", Employee.class);
        query.getResultList().stream().forEach(e -> System.out.println(e));
    }

    public void deleteEmployee() {
        System.out.print("Enter Employee Id to delete: ");
        String emId = scan.nextLine();

        Transaction tx = session.beginTransaction();
        Employee em = session.get(Employee.class, emId);
        if(em != null) {
            session.remove(em);
            System.out.println("Employee deleted Successfully!");
        } else {
            System.out.println("Employee doesn't exists!");
        }
        tx.commit();
    }
}
