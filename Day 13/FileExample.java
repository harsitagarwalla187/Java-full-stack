import java.io.File;
import java.io.IOException;

public class FileExample {
     public static void main(String[] args) throws IOException {

          File f1 = new File("file.txt");
          System.out.println("Is file exists: " + f1.exists());   // false
          System.out.println("Can File read: " + f1.canWrite());  // false
          System.out.println("File name: " + f1.getName());       // file1.txt
          System.out.println("File length: " + f1.length());        // 0
          System.out.println();

          File f2 = new File("file2.txt");
          f2.createNewFile();
          System.out.println("Is file exists: " + f2.exists());   // true
          System.out.println("Can File read: " + f2.canWrite());  // true
          System.out.println("File name: " + f2.getName());       // file2.txt
          System.out.println("File length: " + f2.length());        // 0
          System.out.println("Absolute Path: " + f2.getAbsolutePath()); // e:\Tech-Mahindra-Training\Day 13\file2.txt
          // f2.delete();
          // System.out.println("Is file exists: " + f2.exists());   // true
          
          System.out.println("Ends with: " + f2.getName().endsWith(".txt"));
          System.out.println("Ends with: " + f2.getName().endsWith(".pdf"));

    }
}