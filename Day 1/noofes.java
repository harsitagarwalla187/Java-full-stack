public class noofes {
     public static void main(String[] args) {

          String str = "Excellent";

          int count = 0;

          for(int i=0; i<str.length(); i++) {
               if(str.charAt(i) == 'E' || str.charAt(i) == 'e') count++;
          }

          System.out.println(count);

     }
}