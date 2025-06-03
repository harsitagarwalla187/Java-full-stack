import java.io.*;

public class Student implements Serializable {
     private String name;
     private int uid;

     public Student(int uid, String name) {
          this.uid  = uid;
          this.name = name;
     }

     public String toString() {
          return "Name: " + name + " UID: " + uid;
     }
}