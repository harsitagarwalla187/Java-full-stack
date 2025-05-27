import java.util.ArrayList;
import java.util.Collections;

class StudentManager {
     ArrayList<String> students;

     StudentManager() {
          students = new ArrayList<>();
     }

     public void addStudent(String name) {
          if(!students.contains(name)) {
               students.add(name);
               Collections.sort(students);
          }
     }

     public void removeStudent(String name) {
          if(students.contains(name)) {
               students.remove(name);
          }
     }

     public void isPresent(String name) {
          if(students.contains(name)) {
               System.out.println("Student is present!");
          } else {
               System.out.println("Student is not present!");
          }
     }

     public void showStudents() {
          System.out.println("Students present are: ");
          System.out.println(students);
     }
}

public class ClassroomAttendanceSystem {
     public static void main(String[] args) {
          StudentManager sm = new StudentManager();
          sm.addStudent("Harsit");
          sm.addStudent("Krishna");
          sm.addStudent("Anmol");

          sm.showStudents();
          sm.isPresent("Anmol");
          sm.removeStudent("Anmol");
          sm.showStudents();
          sm.isPresent("Anmol");
     }
}