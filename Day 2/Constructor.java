class Constructor { 


     Constructor() {
         System.out.println("Constructor called");
     }

     public static void main(String args[]) {
          Constructor obj = new Constructor();
          System.out.println("Object Created");
     }
}

// Types of constructor
// 1. Default constructor
// 2. Parameterized constructor

// WE CAN'T USE NON-STATIC VALUES / METHODS INSIDE AN STATIC FUNCTION/METHOD