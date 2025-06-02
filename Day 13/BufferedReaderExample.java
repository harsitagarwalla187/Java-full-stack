import java.io.*;

public class BufferedReaderExample {
    public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new FileReader("newCopyFile.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("charStreamPasted.txt"));

          //   int i = br.read();
          //   while(i != -1) {
          //       bw.write(i);
          //       System.out.print((char)i);
          //       i = br.read(); 
          //   }

          String s;
          while((s=br.readLine()) != null) {
               System.out.println(s);
          }

            br.close();
            bw.close();
    }
}
