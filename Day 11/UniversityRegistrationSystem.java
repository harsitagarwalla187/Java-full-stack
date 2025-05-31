import java.util.Optional;

class Student {
     Optional<String> rollNo;
     Student(String rollNo) {
          this.rollNo = Optional.ofNullable(rollNo);
     }

     public Optional<String> getRollNumber() {
          return rollNo;
     }
}

public class UniversityRegistrationSystem {
     public static void main(String[] args) {

          Student s1 = new Student("2121312");
          Student s2 = new Student(null);

          printRollNum(s1);
          printRollNum(s2);
     }

     public static void printRollNum(Student s) {
          // if(s.getRollNumber().isPresent())
          //      System.out.println(s.getRollNumber());
          // System.out.println(s.getRollNumber().get()); -> error when roll number not present
          System.out.println(s.getRollNumber().orElse("No Roll number"));
     }
}