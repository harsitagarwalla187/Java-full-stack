import java.util.List;
import java.util.ArrayList;

interface Notification {
     public void send();
}

class Email implements Notification {
     @Override
     public void send() {
          System.out.println("Email Notification!");
     }
}

class SMS implements Notification {
     @Override
     public void send() {
          System.out.println("SMS Notification!");
     }
}

class PushNotification implements Notification {
     @Override
     public void send() {
          System.out.println("Push Notification!");
     }
}

public class Main8 {
     public static void main(String[] args) {

          List<Notification> bank = new ArrayList<>();

          bank.add(new Email());
          bank.add(new SMS());
          bank.add(new PushNotification());

          for(Notification notify:bank) {
               notify.send();
          }
     }
}