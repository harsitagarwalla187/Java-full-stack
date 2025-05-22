class College {
     private String collegeName;

     College(String collegeName) {
          this.collegeName = collegeName;
     }

     class Department {
          private String deptName;

          Department(String deptName) {
               this.deptName = deptName;
          }

          public void showDetails() {
               System.out.println("College: " + collegeName);
               System.out.println("Department: " + deptName);
          }
     }
}

class InnerClass {
     public static void main(String[] args) {
          College c = new College("Chandigarh University");

          College.Department dept = c.new Department("Computer Science");
          dept.showDetails();
     } 
}