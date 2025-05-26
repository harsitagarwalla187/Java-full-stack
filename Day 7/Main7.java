import java.util.List;
import java.util.ArrayList;

public class Main7 {
     public static void main(String[] args) {
          List<Object> arr = new ArrayList<>();

          arr.add("Hello"); 
          arr.add(1); 
          arr.add(1.1f); 
          arr.add(2.2d); 
          arr.add(true); 
          arr.add('b');
          arr.add(1_00_00_000);

          System.out.println(arr); 
     }
}