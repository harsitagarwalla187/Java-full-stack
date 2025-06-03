import java.io.*;

class User implements Serializable {
     private int id;
     private String name;

     public User(int id, String name) {
          this.id = id;
          this.name = name;
     }

     public String toString() {
          return "User Id: " + id + " User name: " + name;
     }
}

public class OutputSerialization {
     public static void main(String[] args) throws IOException {

          FileOutputStream fos = new FileOutputStream("serialization.txt");
          ObjectOutputStream oos = new ObjectOutputStream(fos);

          User user = new User(234, "Ramesh");
          oos.writeObject(user);

          oos.close();
          fos.close();
     }
}