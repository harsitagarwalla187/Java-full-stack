import java.time.LocalTime;

public class OfficeHours {
     public static void main(String[] args) {

          LocalTime start = LocalTime.of(9, 00);
          LocalTime end = LocalTime.of(17, 00);
          
          LocalTime entry = LocalTime.of(9, 12);

          System.out.println(entry.isAfter(start) && entry.isBefore(end));
     }
}