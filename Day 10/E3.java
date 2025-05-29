import java.util.Comparator;
import java.util.Collections;
import java.util.ArrayList;

class Applicant {
     String name, qualification;
     int yoe, expectedSalary;

     Applicant(String name, String qualification, int yoe, int expectedSalary) {
          this.name = name;
          this.qualification = qualification;
          this.yoe = yoe;
          this.expectedSalary = expectedSalary;
     }

     @Override
     public String toString() {
          return "Name: " + name + " Qual: " + qualification + " YOE: " + yoe + " Expected Salary: " + expectedSalary; 
     }
}

public class E3 {
     public static void main(String[] args) {

          ArrayList<Applicant> applications = new ArrayList<>();
          applications.add(new Applicant("Aman", "MBA", 5, 12_00_000));
          applications.add(new Applicant("Rohan", "B.Tech", 9, 17_00_000));
          applications.add(new Applicant("Krishna", "M.Tech", 2, 7_00_000));
          applications.add(new Applicant("Harsh", "BCA", 6, 10_00_000));
          applications.add(new Applicant("Raman", "B.Tech", 10, 38_00_000));

          // System.out.println("Original List:");
          // System.out.println(applications);

          // Collections.sort(applications, (a, b) -> a.yoe - b.yoe);
          // System.out.println("\nSorted by Experience:");
          // System.out.println(applications);

          // Collections.sort(applications, (a, b) -> a.expectedSalary - b.expectedSalary);
          // System.out.println("\nSorted by Expected Salary:");
          // System.out.println(applications);

          // Collections.sort(applications, (a, b) -> a.qualification.compareTo(b.qualification));
          // System.out.println("\nSorted by Qualification:");
          // System.out.println(applications);

          // applications.stream().sorted((a, b) -> b.yoe - a.yoe).forEach(System.out::println);
     }
}
