import java.util.ArrayList;
import java.util.Arrays;

public class LCS {
     public static void LIS(ArrayList<Integer> arr) {
          
          int l = arr.size(), count = 1, ans = 0;
          for(int i=1; i<l; i++) {
               if(arr.get(i) > arr.get(i-1)) {
                    count++;
                    ans = Math.max(ans, count);
               } else {
                    count = 1;
               }
          }

          System.out.println(ans);

     }

     public static void main(String[] args) {
          
          ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(11,3,4,7,8,12,2,3,7));
          LIS(arr1);

          ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(1,3,2,1));
          LIS(arr2);

          ArrayList<Integer> arr3 = new ArrayList<>(Arrays.asList(2,17,21,3,7,9,10,11,33,100,4,8));
          LIS(arr3);

     }
}