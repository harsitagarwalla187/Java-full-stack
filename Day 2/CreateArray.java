public class CreateArray {
     public static void main(String args[]) {
          int arr[] = new int[10];
          char ch[] = new char[10];
          String str[] = new String[10];

          for(int i=0; i<10; i++) {
               arr[i] = i;
          }

          for(int i=0; i<10; i++) {
               System.out.println(arr[i]);
          }
     }
}