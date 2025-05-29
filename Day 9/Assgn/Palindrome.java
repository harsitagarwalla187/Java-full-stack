import java.util.Scanner;

interface CheckPalindrome {
     void isPalindrome(int a);
}

public class Palindrome {
     public static void main(String[] args) {
          Scanner scan = new Scanner(System.in);
          int t = scan.nextInt();
          int[] arr = new int[t];
          for(int i=0; i<t; i++) {
               arr[i] = scan.nextInt();
          }

          CheckPalindrome cp = (int a) -> {
               int temp = a;
               int rev = 0;
               while(temp > 0) {
                    rev = rev*10 + temp%10;
                    temp = temp/10;
               }

               if(rev == a) {
                    System.out.println(a + " is a Palindrome!");
               } else {
                    System.out.println(a + " is not a Palindrome!");
               }
          };

          for(int i:arr) {
               cp.isPalindrome(i);
          }
     }
}