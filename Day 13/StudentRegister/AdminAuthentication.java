import java.io.*;
import java.util.Scanner;

public class AdminAuthentication {
     private String username, password;

     AdminAuthentication() {
          addAdmin();
     }
     
     void addAdmin() {
          this.username = "Harsit";
          this.password = "0000";
     }

     boolean validateAdmin(String username, String password) {
          if(this.username.equals(username) && this.password.equals(password)) {
               System.out.println("Welcome Admin!");
               return true;
          } else {
               System.out.println("Wrong Username/Password!");
               return false;
          }
     }

     public void loggedIn() throws IOException, ClassNotFoundException {

          File file = new File("student.bin");
          FileOutputStream fos = new FileOutputStream(file, true);
          boolean append = file.exists() && file.length() > 0;
          ObjectOutputStream oos = append ? new SerialConfig(fos) : new ObjectOutputStream(fos);

          Scanner scan = new Scanner(System.in);
          boolean flag = true;
          while(flag) {
               System.out.println("Select: ");
               System.out.println("1. Add Student.");
               System.out.println("2. Display all students.");
               System.out.println("3. Exit.");
               int option = scan.nextInt();
               scan.nextLine();

               switch(option) {
                    case 1:   System.out.print("Enter Student name: ");
                              String name = scan.nextLine();
                              System.out.print("Enter Student roll number: ");
                              int rollNum = scan.nextInt();
                              Student s = new Student(rollNum, name);
                              oos.writeObject(s);
                              System.out.println("Student added successfully!");
                              break;
                    case 2:   try {
                                   System.out.println("Details of all registered students are:");
                                   ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.bin"));
                                   while (true) {
                                        Student s1 = (Student) ois.readObject();
                                        System.out.println(s1);
                                   }      
                              } catch(EOFException e) {
                                   System.out.println("*** END ***");
                              } catch(Exception e) {
                                   System.out.println(e.getMessage());
                              }
                              break;
                    default:   flag = false;
               }
          }
     }
}