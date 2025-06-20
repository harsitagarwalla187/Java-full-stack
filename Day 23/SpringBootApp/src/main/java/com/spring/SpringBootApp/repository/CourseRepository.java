package com.spring.SpringBootApp.repository;

import com.spring.SpringBootApp.entity.Course;
import com.spring.SpringBootApp.entity.Student;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseRepository {

    @Autowired
    SessionFactory factory;

    public void addCourseWithStudents(Course course) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.persist(course);
        session.getTransaction().commit();
        session.close();
    }

    public void enrollStudentToCourse(long studentId, long courseId) {
        Session session = factory.openSession();
        session.beginTransaction();

        Course course = session.get(Course.class, courseId);
        Student student = session.get(Student.class, studentId);

        course.addStudent(student);
        session.persist(course);

        session.getTransaction().commit();
        session.close();
    }

    public void getAllCoursesWithStudentCount() {
        Session session = factory.openSession();

        TypedQuery<Course> query = session.createQuery("SELECT c FROM Course c", Course.class);
        List<Course> result = query.getResultList();

        for (Course course : result) {
            String title = course.getTitle();
            int count = (course.getStudents() != null) ? course.getStudents().size() : 0;
            System.out.println("Course: " + title + ", Student Count: " + count);
        }

        session.close();
    }


    public void getTop3CoursesByEnrollment() {
        Session session = factory.openSession();

        TypedQuery<Course> query = session.createQuery("SELECT c FROM Course c", Course.class);
        List<Course> result = query.getResultList();

        result.stream()
                .sorted((c1, c2) -> Integer.compare(
                        (c2.getStudents() != null ? c2.getStudents().size() : 0),
                        (c1.getStudents() != null ? c1.getStudents().size() : 0)))
                .limit(3)
                .forEach(course -> {
                    String title = course.getTitle();
                    int count = (course.getStudents() != null) ? course.getStudents().size() : 0;
                    System.out.println("Course: " + title + ", Enrolled Students: " + count);
                });

        session.close();
    }
}
