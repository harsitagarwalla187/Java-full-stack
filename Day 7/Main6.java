// Generic Method 

public class Main6 {
     public static <T> void printArray(T[] arr) {
          for(T i:arr) {
               System.out.println(i);
          }
     }
     public static void main(String[] args) {

          String str[] = {"Amit", "Ravi", "Sita"};
          Integer arr[] = {1, 2, 3, 4};
          Double db[] = {1.1, 2.2, 3.3, 4.4, 5.5};

          printArray(str);
          printArray(arr);
          printArray(db);

     }    
}

// Syntax:

// public <T> ReturnType methodName(T param) {
//     // Method body using param of type T
// }