// School Report Card Generator
// Scenario: Calculate total, grade, and rank students.

// Classes & Structure:
// class Student implements Comparable<Student> { String name; List<Subject> subjects; }
// class Subject { String name; int marks; }

// Methods:
// int totalMarks()
// char getGrade()
// Hints: Use stream to total marks, Comparator for rank

// Input:
// Marks: 95, 85, 75
// Output:
// Total=255, Grade=A
// Rank: 1

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

class Subject {
     String name;
     int marks;

     Subject(String name, int marks) {
          this.name = name;
          this.marks = marks;
     }
}

class Student implements Comparable<Student> {
     String name;
     List<Subject> subjects;
     int total, rank;
     String grade;

     Student(String name, List<Subject> subjects) {
          this.name = name;
          this.subjects = subjects;
          total = 0;

          for(Subject i:subjects) {
               total += i.marks;
          }

          // total = subjects.stream().mapToInt(s -> s.marks).sum();
          setGrade();
     }

     public void setGrade() {
          if(total/3 >= 90) {
               grade = "O";
          } else if(total/3 >= 80) {
               grade = "A";
          } else if(total/3 >= 70) {
               grade = "B";
          } else if(total/3 >= 50) {
               grade = "C";
          } else if(total/3 >= 35) {
               grade = "D";
          } else {
               grade = "F";
          }
     }

     void setRank(int i) {
          this.rank = i;
     }

     @Override
     public String toString() {
          return "Total = "+total+" Rank = " + rank + " Grade = " + grade;
     }

     public int compareTo(Student s) {
          return s.total - this.total;
     }
}

public class StudentReportCardGenerator {
     public static void main(String[] args) {

          ArrayList<Student> students = new ArrayList<>();
          students.add(new Student("S1", Arrays.asList(new Subject("Sub1", 90), new Subject("Sub2", 98), new Subject("Sub3", 90))));
          students.add(new Student("S2", Arrays.asList(new Subject("Sub1", 50), new Subject("Sub2", 75), new Subject("Sub3", 90))));
          students.add(new Student("S3", Arrays.asList(new Subject("Sub1", 40), new Subject("Sub2", 66), new Subject("Sub3", 55))));

          Collections.sort(students);
          for(int i=0; i<students.size(); i++) {
               students.get(i).setRank(i+1);
          }

          students.stream().forEach(System.out::println);
     }
}