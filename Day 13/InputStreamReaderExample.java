import java.io.*;        

public class InputStreamReaderExample {
     public static void main(String[] args) throws IOException {

          InputStreamReader isr = new InputStreamReader(new FileInputStream("newCopyFile.txt"));
          OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("charStreamPasted.txt"));

          int c = isr.read();
          while(c != -1) {
               osw.write((char)c);
               c = isr.read();
          }

          isr.close();
          osw.close();
     }
}