import java.time.LocalDate;

public class GymExpiry {
     public static void main(String[] args) {
          LocalDate date = LocalDate.of(2025, 05, 31);
          System.out.println("Joining Date : " + date);
          date = date.plusMonths(3);
          System.out.println("Expiry Date  : " + date);
     }
}