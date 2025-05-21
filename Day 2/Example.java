import java.util.Scanner;

class Example {
     public static void main(String args[]) {
          Scanner sc = new Scanner(System.in);
          int arr[] = new int[10];
          for(int i=0; i<10; i++) {
               arr[i] = sc.nextInt();
          }
          calculateSum(arr);
     }

     static void calculateSum(int arr[]) {
          int l = arr.length;
          int sum = 0;
          for(int i=0; i<l; i++) {
               sum += arr[i];
          }
          System.out.println("Sum of array is " + sum);
     }
}