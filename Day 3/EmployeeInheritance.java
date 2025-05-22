class Employee {
     String name;
     int eid;
     void work() {
          System.out.println(name + " is working.");
     }
}

class Professor extends Employee {
     String subject;
     void teach() {
          System.out.println(name + " teaches " + subject );
     }
}

class AdminStaff extends Employee {
     String department;
     void manage() {
          System.out.println(name + " is managing " + department);
     }
}

public class EmployeeInheritance {
     public static void main(String args[]) {

          Professor p = new Professor();
          p.name = "Prof. Surya Kr";
          p.eid  = 2121334;
          p.subject = "Java";
          p.work();
          p.teach(); 

          AdminStaff a = new AdminStaff();
          a.name = "Ramesh";
          a.eid = 2222222;
          a.department = "CSE";
          a.work();
          a.manage();
     }
}