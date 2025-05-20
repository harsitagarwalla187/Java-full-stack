import java.util.Scanner;

public class larger {
     public static void main(String[] args) {
          int a, b;
          Scanner sc = new Scanner(System.in);
          a = sc.nextInt();
          b = sc.nextInt();
          System.out.println(a>b ? a+" is greater" : b+" is greater");
     }
}