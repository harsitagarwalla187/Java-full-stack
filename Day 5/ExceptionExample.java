// public class ExceptionExample {
//      public static void main(String[] args) {

//           // String s = null;
//           // String s;
//           // System.out.println(s.length());    

//           try {
//                System.out.println("This is my progress of exception handling.");
//                System.out.println("This is my ending");
//           } catch(Exception ae) {
//                System.out.println("Exception catch is called");
//           } finally {
//                System.out.println("Final is called");
//           }

//      }
// }

public class ExceptionExample {
     public static void main(String[] args) {
          int balance = 2000;
          int withdrawal = 5000;

          // // Throwing exceptions using default exceptions
          // if(withdrawal > balance) {
          //      throw new ArithmeticException("Insuffiecient balance!");
          // } 

          // Throwing exceptions using our built exceptions

          try {
               if(balance <withdrawal) {
                    // throw new ArithmeticException();
                    throw new ArithmeticException("Error!");
               } 
          } catch(ArithmeticException e) {
               System.out.println(e.getMessage());
               System.out.println("Hello");
          } finally {
               System.out.println("Program ends here!");
          }
     }
}