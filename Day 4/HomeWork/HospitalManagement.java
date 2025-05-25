class Staff {
     String name;
     int id;
     double salary;

     public void calculateSalary(double salary, double bonus) {
          this.salary =  salary + bonus;
     }
}

class Doctor extends Staff {}

class Nurse extends Staff {}

class AdminStaff extends Staff {}

public class HospitalManagement {
     public static void main(String[] args) {

     }
}