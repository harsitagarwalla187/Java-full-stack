class Example2 {
     public static void main(String[] args) {
          Test t = new Test();
          t.setter(0);
          t.checkMarks();
     }
}

class Test {
     private int marks;

     void setter(int mark) {
          marks = mark;
     }

     void checkMarks() {
          if (marks >= 35) {
               System.out.println("Pass");
          } else {
               System.out.println("Fail");
          }
     }
}