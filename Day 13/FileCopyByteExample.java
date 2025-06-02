import java.io.*;

public class FileCopyByteExample {
     public static void main(String[] args) throws IOException {

          String source = "newCopyFile.txt";          
          String destination = "newPastedFile.txt";          

          FileInputStream fis = new FileInputStream(source);
          FileOutputStream fos = new FileOutputStream(destination);

          byte[] byt = new byte[1024];
          int i = fis.read(byt);
               while(i != -1) {
               fos.write(byt, 0, i);
               i = fis.read(byt);
          }

          fos.close();
          fis.close();

     }
}