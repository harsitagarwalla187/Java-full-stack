import java.util.Scanner;

public class LoginSystem {
     public static void main(String[] args) {
          try {

               System.out.println("********************************************");
               System.out.println("         Welcome to Login System");
               System.out.println("********************************************");
               Scanner sc = new Scanner(System.in);
               String name = sc.nextLine();
               String password = sc.nextLine();
               sc.close();

               if(name.length() == 0 && password.length() == 0) {
                    throw new IllegalArgumentException("Name and Passowrd");
               } else if(name.length() == 0) {
                    throw new IllegalArgumentException("Name");
               } else if(password.length() == 0) {
                    throw new IllegalArgumentException("Password");
               }


          } catch(Exception e) {
               System.out.println(e.getMessage() + " can't be empty!");
          } finally {
               System.out.println("********************************************");
          }
     }
}
