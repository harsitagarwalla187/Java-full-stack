import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class customSort implements Comparator<Integer> {
     public int compare(Integer i, Integer j) {
          return i%10 - j%10;
     }
}

public class Task1 {
     public static void main(String[] args) {
          ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(37, 24, 22, 17, 35));
          System.out.println(arr);
          Collections.sort(arr, new customSort());
          System.out.println(arr);
     }
}