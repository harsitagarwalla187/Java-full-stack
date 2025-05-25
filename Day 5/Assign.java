import java.util.Scanner;

public class Assign {
     public static void main(String[] args) {

          try {
               Scanner sc = new Scanner(System.in);
               System.out.println("Enter a number between 0 and 100: ");
               int x = sc.nextInt();
               sc.close();

               if(x < 0 || x > 100) {
                    throw new IllegalArgumentException("Invalid number.");
               }
          } catch(IllegalArgumentException e) {
               System.err.println(e.getMessage());
          }

     }
}
