package com.myapp.repository;

import com.myapp.model.Department;
import com.myapp.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentRepository {

    @Autowired
    SessionFactory factory;

    public void addDepartment(Department department) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.persist(department);

        tx.commit();
        session.close();
    }

    public List<Department> showAllDepartmentAndEmployees() {
        Session session = factory.openSession();
        session.beginTransaction();

        Query<Department> query = session.createQuery(
                "SELECT DISTINCT d FROM Department d LEFT JOIN FETCH d.employees",
                Department.class);

        List<Department> list = query.getResultList();

        session.getTransaction().commit();
        session.close();

        return list;
    }

    public void addEmployee(long departmentId, Employee newEmployee) {
        Session session = factory.openSession();
        session.beginTransaction();

        Department department = session.get(Department.class, departmentId);
        department.addEmployee(newEmployee);
        session.persist(department);

        session.getTransaction().commit();
        session.close();
    }

    public void removeEmployee(long departmentId, long employeeId) {
        Session session = factory.openSession();
        session.beginTransaction();

        Department department = session.get(Department.class, departmentId);
        if (department != null) {
            department.removeEmployee(employeeId);
        }

        session.getTransaction().commit();
        session.close();
    }

    public void removeDepartment(long departmentId) {
        Session session = factory.openSession();
        session.beginTransaction();

        Department department = session.get(Department.class, departmentId);
        session.remove(department);

        session.getTransaction().commit();
        session.close();
    }
}
