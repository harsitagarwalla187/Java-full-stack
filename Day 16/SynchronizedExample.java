class ExamPortal {
     void submitAnswers(String studentName) {
          synchronized (this) {
               System.out.println(studentName + "'s sheet has been submitted!");
          }
     }
}

class Student extends Thread {
     String name;
     ExamPortal ep;

     Student(ExamPortal ep, String name) {
          this.ep = ep;
          this.name = name;
     }

     public void run() {
          ep.submitAnswers(name);
     }
}

public class SynchronizedExample {
     public static void main(String[] args) {

          ExamPortal ep = new ExamPortal();

          Student s1 = new Student(ep, "Harsit");
          Student s2 = new Student(ep, "Harsh");

          s1.start();
          s2.start();
     }
}