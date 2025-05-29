public class DigitSum {
     static int digitSum(int t) {

          int a = t;
          if(t<0) {
               a = a*(-1);
          }

          if(a/10 == 0) return a;
          
          int sum = 0;
          while(a > 0) {
               sum += a%10;
               a = a/10;
          }

          return (t<0) ? (-1) * digitSum(sum) : digitSum(sum);
     } 

     public static void main(String[] args) {

          System.out.println(digitSum(976592));
          System.out.println(digitSum(123456));
          System.out.println(digitSum(-123456));


     }
}