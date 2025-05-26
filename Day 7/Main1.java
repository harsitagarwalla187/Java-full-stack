class Student {
     int id, age;
     String name;

     Student(int id, int age, String name) {
          this.id = id;
          this.age = age;
          this.name = name;
     }

     public String toString() {
          return id + " " + age + " " + name;
     }
}

public class Main1 {
     public static void main(String[] args) {
          Student s = new Student(1, 11, "Eleven");
          System.out.println(s); // similar to s.toString() compiler calls is automatically
          System.out.println(s.hashCode()); // returns the hashCode based on the memory address irrespective of the contents of s
          System.out.println(s.getClass());
     }
}

// If we call toString() without overriding the method then it will output the object refernce
// We don't have to write "extends Object" when we override toString(), its done automatically.