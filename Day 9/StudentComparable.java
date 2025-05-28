import java.util.ArrayList;
import java.util.Collections;

class Student implements Comparable<Student> {
    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(Student s) {
//        return this.id - s.id; // Ascending Order
        return s.id - this.id; // Descending Order
    }

    @Override
    public String toString() {
        return "Student TD: " + id + " Student Name: " + name;
    }
}

public class StudentComparable {
    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(3, "Aman"));
        students.add(new Student(1, "Harsit"));
        students.add(new Student(2, "Kuldeep"));
        students.add(new Student(5, "Deepak"));

        System.out.println(students);
        Collections.sort(students);
        System.out.println(students);
    }
}
