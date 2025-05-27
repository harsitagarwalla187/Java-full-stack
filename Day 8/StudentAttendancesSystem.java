import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.Scanner;

class Attendance {
     private HashSet<String> todayAttendance;
     private LinkedHashSet<String> arrivalOrder;
     private TreeSet<String> monthlyAttendance;

     Attendance() {
          todayAttendance = new HashSet<>();
          arrivalOrder = new LinkedHashSet<>();
          monthlyAttendance = new TreeSet<>();
     }

     public void markAttendance(String name) {
          if(!todayAttendance.contains(name)) {
               todayAttendance.add(name);
               arrivalOrder.add(name);
               monthlyAttendance.add(name);
          }
     }

     public void todayAttendance() {
          System.out.println("Today Attendance: " + this.todayAttendance);
     }

     public void displayArrivalOrder() {
          System.out.println("Arrival Order: " + this.arrivalOrder);
     }

     public void displayMonthlyReport() {
          System.out.println("Monthly Report: " + this.monthlyAttendance);
     }

     public void resetDay() {
          todayAttendance.clear();
          arrivalOrder.clear();
     }
}

public class StudentAttendancesSystem {
     public static void main(String[] args) {
          
          Scanner scan = new Scanner(System.in);
          Attendance at = new Attendance();

          System.out.println("Enter 5 students name:");

          for(int i=0; i<5; i++) {
               at.markAttendance(scan.nextLine());
          }

          at.todayAttendance();
          at.displayArrivalOrder();
          at.displayMonthlyReport();
          at.resetDay();
     }
}