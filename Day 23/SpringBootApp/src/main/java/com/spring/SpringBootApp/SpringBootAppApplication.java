package com.spring.SpringBootApp;

import com.spring.SpringBootApp.entity.Course;
import com.spring.SpringBootApp.entity.Student;
import com.spring.SpringBootApp.service.CourseService;
import com.spring.SpringBootApp.service.StudentService;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class SpringBootAppApplication {

	@Bean
	public SessionFactory sessionFactory() {
		return new Configuration().configure().buildSessionFactory();
	}

	public static void main(String[] args) {
		ApplicationContext context = (AnnotationConfigApplicationContext) SpringApplication.run(SpringBootAppApplication.class, args);
		CourseService cs = context.getBean(CourseService.class);
		StudentService ss = context.getBean(StudentService.class);

		System.out.println("--- Welcome to Course Management System. ---");

		boolean flag = true;
		Scanner scan = new Scanner(System.in);

		do {
			System.out.println("Select One Option Only :-");
			System.out.println("1. Add Course with Students");
			System.out.println("2. Enroll Student to Course");
			System.out.println("3. Get all course with Student count");
			System.out.println("4. Get top 3 course by student enrollment");
			System.out.println("5. Remove student");
			System.out.println("6. Exit");
			System.out.print("Enter the option: ");
			int userInput = scan.nextInt();
			scan.nextLine();

			switch(userInput) {
				case 1:
					System.out.println("--- Add Course with Students ---");
					Course newCourse = new Course();
					System.out.print("Enter Course title: ");
					newCourse.setTitle(scan.nextLine());
					System.out.print("Enter Course duration(in weeks): ");
					newCourse.setDuration(scan.nextInt());
					scan.nextLine();
					System.out.print("Enter number of students: ");
					int n = scan.nextInt();
					scan.nextLine();
					for(int i=0; i<n; i++) {
						Student student = new Student();
						System.out.println("Enter Student " + (i+1) + " details...");
						System.out.print("Enter student name: ");
						student.setName(scan.nextLine());
						System.out.print("Enter student email: ");
						student.setEmail(scan.nextLine());
						newCourse.addStudent(student);
					}
					cs.addCourseWithStudents(newCourse);
					break;
				case 2:
					System.out.println("--- Enroll Student to Course ---");
					System.out.print("Enter student Id: ");
					long SID = scan.nextLong();
					System.out.print("Enter course id: ");
					long CID = scan.nextLong();
					scan.nextLine();
					cs.enrollStudentToCourse(SID, CID);
					break;
				case 3:
					System.out.println("--- Get all course with Student count ---");
					cs.getAllCoursesWithStudentCount();
					break;
				case 4:
					System.out.println("--- Get top 3 course by student enrollment ---");
					cs.getTop3CoursesByEnrollment();
					break;
				case 5:
					System.out.println("--- Remove student ---");
					System.out.print("Enter student id: ");
					ss.removeStudent(scan.nextLong());
					scan.nextLine();
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