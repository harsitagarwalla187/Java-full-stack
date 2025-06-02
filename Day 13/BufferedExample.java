import java.io.*;

public class BufferedExample {
    public static void main(String[] args) throws IOException {

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("FileExample.java"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("FileExample.txt"));

        int j;
        do {
            j = bis.read();
            if(j != -1) {
                bos.write(j);
            }
        } while(j != -1);

        bis.close();
        bos.close();
    }
}
