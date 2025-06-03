import java.io.*;
import java.util.Scanner;

public class StudentRegister {
     public static void main(String[] args) throws IOException, ClassNotFoundException  {

          Scanner scan = new Scanner(System.in);
          AdminAuthentication admin = new AdminAuthentication();

          while (true) {
              System.out.println("Hello Admin!\nPlease verify yourself:");
              System.out.print("Username: ");
              String username = scan.nextLine();
              System.out.print("Password: ");
              String password = scan.nextLine();

              if (admin.validateAdmin(username, password)) {
                  admin.loggedIn();
                  break;
              } else {
                  System.out.println("Invalid credentials. Please try again.\n");
              }
          }
     }
}