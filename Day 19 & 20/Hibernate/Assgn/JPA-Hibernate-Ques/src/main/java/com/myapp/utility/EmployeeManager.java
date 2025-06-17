package com.myapp.utility;

import com.myapp.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class EmployeeManager {

    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public List<Employee> getFilteredEmployees() {
        Session session = sessionFactory.openSession();
        String query = "FROM Employee e WHERE e.age > 30 AND e.salary > 50000 AND e.department = 'Engineering'";
        List<Employee> result = session.createQuery(query, Employee.class).getResultList();
        session.close();
        return result;
    }

    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();

        List<Employee> employees = manager.getFilteredEmployees();
        employees.forEach(System.out::println);
    }
}

