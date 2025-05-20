public class palindromeInt {
     public static void main(String[] args) {
          int n = 121;

          int r = 0, temp = n;
          while(temp != 0) {
               r = r*10 + temp%10;
               temp = temp/10;
          }        

          System.out.println(n == r ? "Palindrome!" : "Not Palindrome!");
     }
}