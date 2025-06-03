import java.io.*;

public class InputSerialization {
     public static void main(String[] args) throws IOException, ClassNotFoundException {

          FileInputStream fis = new FileInputStream("serialization.txt");
          ObjectInputStream ois = new ObjectInputStream(fis);

          User user = (User)ois.readObject();
          System.out.println(user);

          ois.close();
          fis.close();
     }
}