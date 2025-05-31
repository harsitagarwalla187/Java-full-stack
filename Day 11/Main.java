import java.util.ArrayList;

class Student {
     int score;
     String name;
     Student(String name, int score) {
          this.score = score;
          this.name = name;
     }

     public int getScore() {
          return score;
     } 

     @Override
     public String toString() {
          return name + " " + score;
     }
}

public class Main {
     public static void main(String[] args) {
          ArrayList<Student> students = new ArrayList<>();
          students.add(new Student("Harsit", 99));
          students.add(new Student("Harsit", 99));
          students.add(new Student("Harsh", 90));
          students.add(new Student("Rohan", 55));
          students.add(new Student("Abhinash", 75));
          students.add(new Student("Ram", 100));
          students.add(new Student("Harsit2", 91));
          students.add(new Student("Harsit3", 45));
          students.add(new Student("harsit4", 85));
          students.add(new Student("Amanya", 65));

          // students
          //   .stream()
          //   .map(Student::getScore)
          //   .distinct()
          //   .sorted((a, b) -> b - a)
          //   .limit(5)
          //   .forEach(System.out::println);
 
          // students
          //      .stream()
          //      // .map(student -> student.score)
          //      .distinct()
          //      .sorted((score1, score2) -> score2.score - score1.score)
          //      .limit(5)
          //      .forEach(score -> System.out.println(score));


     }
}