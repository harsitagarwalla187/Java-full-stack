import java.util.Set;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Iterator;

public class SetExample {
     public static void main(String[] args) {

          Set <String> allGuest = new HashSet<>();

          allGuest.add("Samvid");
          allGuest.add("Ravi");
          allGuest.add("Akash");
          allGuest.add("Ravi");
          allGuest.add("Vishal");

          System.out.println("All Unique Guest: " + allGuest);

          Set<String> newGuest = new LinkedHashSet<>();
          newGuest.add("Aditya");
          newGuest.add("Tushar");
          newGuest.add("Rohan");
          newGuest.add("Mayank");

          System.out.println("Guest by Arrival: " + newGuest);

          SortedSet<String> vipGuest = new TreeSet<>();
          vipGuest.add("Vivek");
          vipGuest.add("Arjun");
          vipGuest.add("Pradeep");
          vipGuest.add("Ashish");

          System.out.println("All VIP Guest in sorted order : " + vipGuest);

          if(allGuest.contains("Mohan")) {
               System.out.println("Mohan has arrived!");
          } else {
               System.out.println("Mohan has not arrived!");
          }

          newGuest.remove("Rohan");
          System.out.println("Updated New Guest: " + newGuest);

          // Iterator
          Iterator<String> it = newGuest.iterator();

          while(it.hasNext()) {
               String value = it.next();
               System.out.println(value);
          }

     }
}