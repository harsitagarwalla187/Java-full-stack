import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//class Student {
//   int id;
//   String name;
//
//   public Student(int id, String name) {
//       this.id = id;
//       this.name = name;
//   }
//
//   @Override
//   public String toString() {
//       return "Student TD: " + id + " Student Name: " + name;
//   }
//}

class CustomComparator implements Comparator<Student> {
    public int compare(Student i, Student j) {
        return i.name.compareTo(j.name);
    }
}

public class StudentComparator {
    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(3, "Aman"));
        students.add(new Student(1, "Harsit"));
        students.add(new Student(2, "Kuldeep"));
        students.add(new Student(5, "Deepak"));

        System.out.println(students);
        Collections.sort(students, new CustomComparator());
        System.out.println(students);
    }
}