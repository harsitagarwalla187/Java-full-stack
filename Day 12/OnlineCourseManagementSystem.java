// Online Course Management System

// Scenario: Build a system to manage courses, assign trainers, and allow student enrollment with validation for course capacity.

// Classes & Structure:
// abstract class User { int id; String name; }
// class Student extends User {}
// class Trainer extends User {}
// class Course { String title; int capacity; List<Student> enrolled; Trainer trainer; }
// Interface Enrollable { void enroll(Student student); }
// Custom Exception: CourseFullException

// Methods:
// enrollStudent(Student s) in Course
// void assignTrainer(Trainer t)
// Hints: Override toString, use streams to list enrolled students.

// Input:
// Create course: Java, Capacity: 2
// Enroll: John, Jane, Alice

// Output:
// John enrolled
// Jane enrolled
// Alice: CourseFullException

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

abstract class User {
     int id;
     String name;
}

class Trainer extends User {
     Trainer(int id, String name) {
          super.id = id;
          super.name = name;
     }
}

class Student extends User {
     Student(int id, String name) {
          super.id = id;
          super.name = name;
     }

     @Override
     public String toString() {
          return super.id + " " + super.name;
     }
}

interface Enrollable {
     void enroll(Student student);
}

class CourseFullException extends Exception {
     public CourseFullException(String e) {
          super(e);
     }
}

class Course implements Enrollable {
     String title;
     int capacity;
     int studentsEnrolled;
     List<Student> enrolled;
     Trainer trainer;

     Course(String title, int capacity) {
          this.capacity = capacity;
          this.studentsEnrolled = 0;
          this.title = title;
          enrolled = new ArrayList<>();
     }

     public void assignTrainer(int id, String name) {
          trainer = new Trainer(id, name);
     }

     public void addStudent() {
          Scanner scan = new Scanner(System.in);
          System.out.println("Enter student details:");
          System.out.print("Enter Student ID:");
          int id = scan.nextInt();
          scan.nextLine();
          System.out.print("Enter Student Name:");
          String name = scan.nextLine();
          enroll(new Student(id, name));
     }

     public void getStudentDetails() {
          enrolled.stream().forEach(System.out::println);
     }

     public void getTrainerDetails() {
          System.out.println("Trainer ID: " + trainer.id + "\nTrainer name: " + trainer.name);
     }

     public void getCourseDetails() {
          System.out.println("Course name: " + title + "\nCourse Capacity: " + capacity + "\nStudents Enrolled: " + studentsEnrolled);
     }

     @Override
     public void enroll(Student student) {
          try {
               if(studentsEnrolled < capacity) {
                    enrolled.add(student);
                    studentsEnrolled++;
               } else {
                    throw new CourseFullException("Capacity is full!");
               }
          } catch(CourseFullException e) {
               System.out.println(e.getMessage());
          }
     }
}

public class OnlineCourseManagementSystem {
     public static void main(String[] args) {

          Scanner scan = new Scanner(System.in);
          System.out.print("Enter Course name: ");
          String courseName = scan.nextLine();
          System.out.print("Enter Course Capacity: ");
          int courseCapacity = scan.nextInt();
          System.out.print("Enter Trainer ID: ");
          int trainerID = scan.nextInt();
          scan.nextLine();
          System.out.print("Enter Trainer Name: ");
          String trainerName = scan.nextLine();

          Course newCourse = new Course(courseName, courseCapacity);
          newCourse.assignTrainer(trainerID, trainerName);

          boolean flag = true, first = true;

          do {
               System.out.println("Select : ");
               System.out.println("1. Add students");
               System.out.println("2. Get Course Details");
               System.out.println("3. Get Trainer Details");
               System.out.println("4. Get Student Details");
               System.out.println("5. Exit");
               int option = scan.nextInt();

               switch(option) {
                    case 1: newCourse.addStudent();
                              break;
                    case 2: newCourse.getCourseDetails();
                              break;
                    case 3: newCourse.getTrainerDetails();
                              break;
                    case 4: newCourse.getStudentDetails();
                              break;
                    default: return;
               }

               System.out.println("Do you want to continue?(Y/N)");
               char ch = scan.next().charAt(0);
               if(ch == 'N' || ch == 'n') {
                    flag = false;
               }
          } while(flag);

     }
}