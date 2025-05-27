import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.Hashtable;

public class MapExample {
     public static void main(String[] args) {
          
          Map<Integer, String> studentMap = new HashMap<>();
          studentMap.put(101, "Ayush");
          studentMap.put(103, "Aditya");
          studentMap.put(null, "virat");
          studentMap.put(123, null);
          studentMap.put(102, "Suresh");
          studentMap.put(103, "Aditya");

          System.out.println("Student Details are: ");

          for(Map.Entry<Integer, String> mp: studentMap.entrySet()) {
               System.out.println("Roll no: " + mp.getKey() + ", " + "Name: " + mp.getValue());
          }
          System.out.println();

          Map<String, Integer> cart = new LinkedHashMap<>();
          cart.put("Laptop", 2);
          cart.put("Mouse", 3);
          cart.put("Keyboard", 2);
          cart.put(null, 2);
          cart.put("Camera", null);

          System.out.println("Shipping Carts are: ");

          for(Map.Entry<String, Integer> mp: cart.entrySet()) {
               System.out.println("Item: " + mp.getKey() + ", " + "Quantity: " + mp.getValue());
          }
          System.out.println();

          Map<Integer, String> emp = new TreeMap<>();
          emp.put(234, "Tushar");
          emp.put(324, "Vivek");
          // emp.put(null, "Vivek");
          emp.put(111, null);
          emp.put(435, "Vishal");
          emp.put(324, "Mayank");

          System.out.println("Employees Details are in sorted ");
          for(Map.Entry<Integer, String> mp: emp.entrySet()) {
               System.out.println("Emp ID: " + mp.getKey() + ", " + "Emp Name: " + mp.getValue());
          }
          System.out.println();

          Map<String, String> users = new Hashtable<>();
          users.put("admin", "admin@123");
          users.put("admin1", "admin1@123");
          // users.put(null, "admin321");
          // users.put("admin2", null);

          System.out.println("User details are: ");

          for(Map.Entry<String, String> mp: users.entrySet()) {
               System.out.println("Username: " + mp.getKey() + ", " + "Password: " + mp.getValue());
          }
     }
}