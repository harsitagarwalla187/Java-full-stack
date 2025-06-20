package com.spring.SpringBootApp.repository;

import com.spring.SpringBootApp.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    @Autowired
    SessionFactory factory;

    public void removeStudent(Long studentId) {
        Session session = factory.openSession();
        session.beginTransaction();

        Student s = session.get(Student.class, studentId);
        if(s != null) {
            session.remove(s);
        }

        session.getTransaction().commit();
        session.close();
    }
}
