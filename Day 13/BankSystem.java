import java.io.*;
import java.time.LocalTime;

class User implements Serializable {
     private String name; 
     private transient String password;
     User(String name, String password) {
          this.name = name;
          this.password = password;
     }

     public String getName() {
          return name;
     }
}

class UserSession extends User implements Serializable {
     public LocalTime loginTime;

     UserSession(String name, String password) {
          super(name, password);
          loginTime = LocalTime.now();
     }

     public String toString() {
          return "Login Time: " + loginTime + "\nName: " + super.getName();
     }
}

public class BankSystem {
     public static void main(String[] args) throws IOException, ClassNotFoundException {
     
          ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("UserDetails.bin"));
          UserSession user = new UserSession("Harsit", "12345678");
          UserSession user2 = new UserSession("Harsh", "87654321");
          UserSession user3 = new UserSession("Hsh", "8721");
          oos.writeObject(user);
          oos.writeObject(user2);
          oos.writeObject(user3);
          oos.close();
          System.out.println("System has been serialized!");
          System.out.println();

          ObjectInputStream ois = new ObjectInputStream(new FileInputStream("UserDetails.bin"));
          UserSession u = (UserSession)ois.readObject();
          UserSession u2 = (UserSession)ois.readObject();
          UserSession u3 = (UserSession)ois.readObject();
          System.out.println(u);
          System.out.println(u2);
          System.out.println(u3);
          // Object u = ois.readObject();
          // System.out.println(u);
          // System.out.println(ois.readObject());
          ois.close();
          System.out.println("System has been deserialized!");
     }
}