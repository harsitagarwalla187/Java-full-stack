import java.io.*;

public class FileOutputStreamExample {
     public static void main(String[] args) throws IOException {

          FileOutputStream fos = new FileOutputStream("file3.txt");

          String data = "Chandigarh University";
          // String data = "Tech M Training";

          for(int i=0; i<data.length(); i++) {
               fos.write(data.charAt(i));
          }
          fos.close();
     }
}