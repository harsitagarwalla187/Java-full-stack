// Interface are used for 100% Abstraction
// All abstract methods should be defined in child class
// Interface methods are by default public and abstract

interface Notification {
     void send(String to, String message);
}

class EmailNotification implements Notification {

     @Override
     public void send(String to, String message) {
          System.out.println("Sending Email to " + to + " : " + message);
     }
}

class SMSNotification implements Notification {

     @Override
     public void send(String to, String message) {
          System.out.println("Sending SMS to " + to + " : " + message);
     }
}

public class Interface {
     public static void main(String[] args) {
          Notification en = new EmailNotification();
          en.send("user@mail.com", "This is Email Notification");

          Notification sn = new SMSNotification();
          sn.send("123456789", "This is SMS Notification");
     }
}