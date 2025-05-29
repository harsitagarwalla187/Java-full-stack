import java.util.Comparator;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// interface MyInterface {
//      void show();
// }

interface MyInterface {
     void show(Applicant a, Applicant b);
}

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

class sortByExperience implements Comparator<Applicant> {
     public int compare(Applicant i, Applicant j) {
          return i.yoe - j.yoe;
     }
}

// class sortByQualification implements Comparator<Applicant> {
//      public int compare(Applicant i, Applicant j) {
//           return i.qualification.compareTo(j.qualification);
//      }
// }

// class sortBySalary implements Comparator<Applicant> {
//      public int compare(Applicant i, Applicant j) {
//           return i.expectedSalary - j.expectedSalary;
//      }
// }

public class E1 {
     public static void main(String[] args) {

          ArrayList<Applicant> applications = new ArrayList<>();
          applications.add(new Applicant("Aman", "MBA", 5, 12_00_000));
          applications.add(new Applicant("Rohan", "B.Tech", 9, 17_00_000));
          applications.add(new Applicant("Krishna", "M.Tech", 2, 7_00_000));
          applications.add(new Applicant("Harsh", "BCA", 6, 10_00_000));
          applications.add(new Applicant("Raman", "B.Tech", 10, 38_00_000));

          // System.out.println(applications);
          // Collections.sort(applications, new sortByExperience());
          // System.out.println(applications);
          // Collections.sort(applications, new sortBySalary());
          // System.out.println(applications);
          // Collections.sort(applications, new sortByQualification());
          // System.out.println(applications);    

          // Anonymous Class
          // Comparator<Applicant> cp1 = new Comparator<Applicant>() {
          //      @Override
          //      public int compare(Applicant i, Applicant j) {
          //           return i.yoe - j.yoe;
          //      }
          // };

          // Comparator<Applicant> cp2 = new Comparator<Applicant>() {
          //      @Override
          //      public int compare(Applicant i, Applicant j) {
          //           return i.expectedSalary - j.expectedSalary;
          //      }
          // };

          // Comparator<Applicant> cp3 = new Comparator<Applicant>() {
          //      @Override
          //      public int compare(Applicant i, Applicant j) {
          //           return i.qualification.compareTo(j.qualification);
          //      }
          // };

          // System.out.println(applications);
          // Collections.sort(applications, cp1);
          // System.out.println(applications);
          // Collections.sort(applications, cp2);
          // System.out.println(applications);
          // Collections.sort(applications, cp3);
          // System.out.println(applications);

          // applications.stream().sorted(new sortByExperience()).forEach(System.out::println);

          // applications.stream().sorted(cp1).forEach(System.out::println);

          // applications.stream().sorted((a, b) -> b.yoe - a.yoe).forEach(System.out::println);

          // applications.stream().sorted(new Comparator<Applicant>() {
          //      public int compare(Applicant i, Applicant j) {
          //           return i.yoe - j.yoe;
          //      }
          // }).forEach(System.out::println);

          List<Applicant> newApplicants = applications.stream().collect(Collectors.toList());
          System.out.println(newApplicants);

     }
}