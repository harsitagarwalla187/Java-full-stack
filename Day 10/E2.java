import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Student implements Comparable<Student> {
     private int rollNo, totalMarks;
     private String name;

     Student(String name, int rollNo, int totalMarks) {
          this.name = name;
          this.rollNo = rollNo;
          this.totalMarks = totalMarks;
     }

     @Override
     public int compareTo(Student o) {
          return o.totalMarks - this.totalMarks;
     }

     @Override
     public String toString() {
          return this.totalMarks + " " + this.rollNo + " " + this.name;
     }
}

public class E2 {
     public static void main(String[] args) {

          List<Student> students = new ArrayList<>();
          students.add(new Student("Harsit", 2, 99));
          students.add(new Student("Harsh", 1, 95));
          students.add(new Student("Aman", 3, 97));

          System.out.println(students);
          Collections.sort(students);
          System.out.println(students);

          // students.stream().sorted(Student::compareTo).forEach(System.out::println);
     }
}