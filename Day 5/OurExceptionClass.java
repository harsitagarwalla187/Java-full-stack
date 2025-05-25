public class OurExceptionClass {
     public static void main(String[] args) {
          int balance = 2000;
          int withdrawal = 5000;

          try {
               if(balance < withdrawal) {
                    throw new InsufficientBalanceException("Insufficient balance!");
               }
          } catch(Exception e) {
               System.out.println(e.getMessage());
          } finally {
               System.out.println("Program ends here!");
          }
     }
}


/*
 * Always declare the catch function for the exception we declare!
 * 
 */
