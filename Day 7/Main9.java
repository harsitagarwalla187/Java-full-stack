import java.util.Scanner;
import java.util.ArrayList;

public class Main9 {
     public static void main(String[] args) {
          Scanner scan = new Scanner(System.in);
          ArrayList<Double> arr = new ArrayList<>();
          System.out.println("Enter the prices of 5 products : ");
          for(int i=0; i<5; i++) {
               arr.add(scan.nextDouble());
          }

          double total = 0.0, mxm = Double.MIN_VALUE, mnm = Double.MAX_VALUE;
          //double mxm = arr.get(0), mnm = arr.get(0);
          for(double i:arr) {
               total += i;
               mxm = Math.max(mxm, i);
               mnm = Math.min(mnm, i);
          }

          System.out.println("Total Price : " + total + "\nMaximum Price : " + mxm + "\nMinimum Price : " + mnm);

     }
}