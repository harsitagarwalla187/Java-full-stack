class Demo {
     {
          System.out.println("Instance Block!");
     }
     
     static {
          System.out.println("Static Block!");
     }

     Demo() {
          System.out.println("Constructor!");
     }
}

public class Blocks {
     // {
     //      System.out.println("Instance Block!");
     // }
     
     // static {
     //      System.out.println("Static Block!");
     // }

     // Blocks() {
     //      System.out.println("Constructor!");
     // }
     public static void main(String[] args) {
          
          System.out.println("Main!");

          // Blocks d1 = new Blocks();
          // Blocks d2 = new Blocks();

          Demo d1 = new Demo();
          Demo d2 = new Demo();
     }
}