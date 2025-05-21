class User {
     static int count = 0;

     User() {
          count++;
     }
}

public class UserMain {
     public static void main(String args[]) {
          // User u1 = 
          new User();
          // User u2 = 
          new User();
          // User u3 = 
          new User();
          // User u4 = 
          new User();
          System.out.println(User.count);
     }
}