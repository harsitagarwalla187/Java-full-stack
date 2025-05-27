import java.util.Map;
import java.util.Hashtable;

class LoginSystem {

     Map<String, String> users;

     LoginSystem() {
          users = new Hashtable<>();
     }

     public void addUser(String username, String password) {
          if(users.containsKey(username)) {
               System.out.println("User already registered!");
          } else {
               users.put(username, password);
               System.out.println("User added successfully!");
          }
     }

     public boolean checkUser(String username) {
          if(users.containsKey(username)) {
               return true;
          } else {
               return false;
          }
     }

     public boolean removeUser(String username) {
          if(users.containsKey(username)) {
               users.remove(username);
               return true;
          } else {
               return false;
          }
     }

     public boolean isUserListEmpty() {
          if(users.isEmpty()) {
               return true;
          } else {
               return false;
          }
     }

     public void userList() {
          System.out.println("Users registered are: ");
          for(Map.Entry<String, String> mp:users.entrySet()) {
               System.out.println(mp.getKey());
          }
     }
}

public class LoginManagementSystem {
     public static void main(String[] args) {
          
          LoginSystem sys = new LoginSystem();
          sys.addUser("harsit", "harsit@123");
          sys.addUser("aman", "aman@123");
          sys.addUser("satoshi", "satoshi@123");
          sys.addUser("harsh", "harsh  123");

          if(sys.checkUser("harsit")) {
               System.out.println("User exists!");
          } else {
               System.out.println("User doesn't exists!");
          }

          // sys.removeUser("harsit");
          sys.userList();

          if(sys.isUserListEmpty()) {
               System.out.println("User List is empty!");
          } else {
               System.out.println("User List is not empty!");
          }

     }     
}