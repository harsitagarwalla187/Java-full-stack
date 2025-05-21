class Student {
     int rollNo;
     String name;

     Student(int rollNo, String name) {
          this.rollNo = rollNo;
          this.name = name;
     }

     public void print() {
          System.out.println("Student Roll No: " + rollNo);
          System.out.println("Student Name: " + name);
     }
 
}

public class ObjectArray {
     public static void main(String[] args) {
          Student std[] = new Student[100];

          for(int i=0; i<100; i++) {
               String name = "Student" + i;
               std[i] = new Student(i, name);
          }

          for(int i=0; i<100; i++) {
               std[i].print();
          }
     }
}