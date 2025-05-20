import java.util.Scanner;

public class noofdigits {
     public static void main(String[] args) {
          int x;
          Scanner sc = new Scanner(System.in);
          x = sc.nextInt();

          int count = 0;
          while(x != 0) {
               count++;
               x=x/10;
          }
          System.out.println(count);

     }
}