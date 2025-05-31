import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

////// 1. Exception Hierarchy (Checked & Unchecked Exceptions)

//// 1.1.	Use FileReader to read user records. Handle FileNotFoundException (checked).


// public class Main {
//      public static void main(String[] args) {
//           try {
//                FileReader fr = new FileReader("student.txt");
//           } catch(FileNotFoundException e) {
//                System.out.println("File not found : " + e.getMessage());
//           }
//      }
// }

//// 1.2.	Accept a username and password. If input is null, throw NullPointerException (unchecked).

// public class Main {
//      public static void main(String[] args) {
//           String username, password;
//           Scanner scan = new Scanner(System.in);

//           username = scan.nextLine();
//           password = scan.nextLine();

//           if(username.length() == 0 || password.length() == 0) {
//                throw new NullPointerException("Input can't be empty!");
//           }
//      }
// }

//// 1.3.	Simulate a transaction and throw IllegalArgumentException if balance is negative.

// public class Main {
//      public static void main(String[] args) {
//           int balance = 2000, withdraw = 3000;
//           if(balance < withdraw) {
//                throw new IllegalArgumentException("Insuffiecient balance!");
//           }
//      }
// }

//// 1.4.	Create a method that throws a dummy SQLException to mimic a failed connection (checked).

// public class Main {
//      public static void main(String[] args) {
//           String url = "jdbc:mysql://localhost:3306/myDB";
//           String user = "harsit";
//           String password = "12345678";

//           try {
//                Connection con = DriverManager.getConnection(url, user, password);
//                System.out.println("Database connected successfully!");
//                con.close();
//           } catch(SQLException e) {
//                System.out.println("Connection failed: "+e.getMessage());
//           }
//      }
// }

//// 1.5.	Implement a calculator that throws ArithmeticException for divide-by-zero scenarios.

// public class Main {
//      public static void main(String[] args) {
//           try {
//                int x = 1, y = 0;
//                int res = x/y; 
//           } catch(ArithmeticException e) {
//                System.out.println("Can't Divide by zero :" + e.getMessage());
//           }
//      }
// }

////// 2. Try-Catch Block (Syntax, Multiple Catches)

//// 2.1.	Read input and catch NullPointerException if email is not entered.

// public class Main {
//      public static void main(String[] args) {
//           try {
//                Scanner scan = new Scanner(System.in);
//                String email = scan.nextLine();

//                if(email.trim().equals("")) {
//                     throw new  NullPointerException("Email cannot be empty!");
//                } 
//           } catch(NullPointerException e) {
//                     System.out.println("NullPointerException : " + e.getMessage());
//           }
//      }
// }

//// 2.2.	Catch FileNotFoundException and IOException using separate catch blocks.

// public class Main {
//      public static void main(String[] args) {
//           try {

//           } catch(FileNotFoundException e) {
//                System.out.println("FileNotFoundException : " + e.getMessage());
//           } catch(IOException e) {
//                System.out.println("IOException : " + e.getMessage());
//           }
//      }
// }

//// 2.3.	Convert user input to an integer. Catch NumberFormatException.

// public class Main {
//      public static void main(String[] args) {
//           try {
//                Scanner scan = new Scanner(System.in);
//                String number = scan.nextLine();

//                int integer = Integer.parseInt(number);
//                System.out.println(integer);
//           } catch(NumberFormatException e) {
//                System.out.println("Wrong format: " + e.getMessage());
//           }
//      }
// }

//// 2.4.	Simulate location update; handle ArrayIndexOutOfBoundsException if index is invalid.

public class Main {
     public static void main(String[] args) {
          try {
               int[] arr = {1, 2, 4};
               System.out.println(arr[4]);
          } catch(ArrayIndexOutOfBoundsException e) {
               System.out.println("Index error: " + e.getMessage());
          }
     }
}