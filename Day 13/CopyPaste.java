import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopyPaste {
     public static void main(String[] args) throws IOException {

          FileInputStream fis = new FileInputStream("fileCopy.java");
          FileOutputStream fos = new FileOutputStream("filePasted.java");

          int i = fis.read();
          while(i != -1) {
               fos.write(i);
               i = fis.read();
          }

          fis.close();
          fos.close();
     }
}