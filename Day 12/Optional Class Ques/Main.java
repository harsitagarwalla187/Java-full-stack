import java.util.Optional;
import java.util.ArrayList;
import java.util.Arrays;

class User {
     Optional<String> bio;

     User(String bio) {
          this.bio = Optional.ofNullable(bio);
     }

     public void displayBio() {
          System.out.println(this.bio.orElse("No bio added!"));
     }
}

class Product {
     double price;
     Optional<Double> discount;

     Product(double price, double discount) {
          this.price = price;
          this.discount = Optional.ofNullable(discount);
     }

     public void displayDiscountedPrice() {
          double res = price - (price * discount.orElse(0.0))/100;
          System.out.println(res);
     }
}

class User2 {
     Optional<String> email;

     User2(String email) {
          this.email = Optional.ofNullable(email);
     }

     public void sendNotification() {
          if(email.isPresent())
               System.out.println("Sending email to: " + this.email.get());
     }
}

class Account {
     Optional<String> ID;

     Account(String ID) {
          this.ID = Optional.ofNullable(ID);
     }

     public void login() {
          System.out.println("Login Successful for " + ID.orElseThrow(() -> new IllegalArgumentException("ID cannot be null!")));
     }
}

class Grade {
     Optional<Integer> grade;
     Grade(Integer grade) {
          this.grade = Optional.ofNullable(grade);
     }
     
     public void checkDistinction() {
          if(grade.filter(g -> g > 75).isPresent()) {
               System.out.println("Student passed with Distinction!");
          };
     }
}

class UserSettings {
     Optional<String> mode;
     UserSettings(String mode) {
          this.mode = Optional.ofNullable(mode);
     }

     public void displayMode() {
          System.out.println("Using theme: " + mode.orElse("Light Mode"));
     }
}

class LibraryUser {
     Optional<String> borrowedBook;
     LibraryUser(String book) {
          this.borrowedBook = Optional.ofNullable(book);
     }

     public void displayBookTitle() {
          System.out.println("Borrowed book: " + borrowedBook.orElse("No book borrowed!"));
     }
}

class Resume {
     Optional<String> profileLink;
     Resume(String profileLink) {
          this.profileLink = Optional.ofNullable(profileLink);
     }

     public void displayProfile() {
          if(profileLink.isPresent()) {
               System.out.println("Linkedin: " + profileLink.get());
          }
     }
}

class SystemConfiguration {
     Optional<String> config;
     SystemConfiguration(String config) {
          this.config = Optional.ofNullable(config); 
     }

     public void getConfig() {
          System.out.println("Loaded config: " + config.orElseGet(() -> loadFromRemote()));
     }

     String loadFromRemote() {
          return "remote_default_value";
     }
}

class InsuranceClaim {
     Optional<String> notes;
     InsuranceClaim(String notes) {
          this.notes = Optional.ofNullable(notes);
     }
     public void getNotes() {
          notes.ifPresentOrElse(
               (value) -> System.out.println("Notes: " + value),
               () -> System.out.println("Notes: No notes added")
          );
     } 
} 

public class Main {
     public static void main(String[] args) {

          // // Q1
          // User user1 = new User("Cool!");
          // User user2 = new User(null);
          // user1.displayBio();
          // user2.displayBio();
          // System.out.println("***********************************");

          // // Q2
          // Product p1 = new Product(900, 10);
          // Product p2 = new Product(1000, 0.0);
          // p1.displayDiscountedPrice();
          // p2.displayDiscountedPrice();
          // System.out.println("***********************************");

          // // Q3
          // User2 user21 = new User2("harsit@gmail.com");
          // User2 user22 = new User2(null);
          // user21.sendNotification();
          // user22.sendNotification();
          // System.out.println("***********************************");

          // Q4
          // Account a1 = new Account("ACC001");
          // Account a2 = new Account(null);
          // a1.login();
          // a2.login();
          // System.out.println("***********************************");

          // Q5
          // Grade g1 = new Grade(78);
          // Grade g2 = new Grade(null);
          // g1.checkDistinction();
          // g2.checkDistinction();

          // Q6
          // UserSettings u1 = new UserSettings(null);
          // UserSettings u2 = new UserSettings("Dark Mode");
          // u1.displayMode();
          // u2.displayMode();

          // Q7
          // LibraryUser l1 = new LibraryUser("Java made easy");
          // LibraryUser l2 = new LibraryUser(null);
          // l1.displayBookTitle();
          // l2.displayBookTitle();

          // Q8
          // Resume r1 = new Resume("linkedin.com/in/johndoe");
          // Resume r2 = new Resume(null);
          // r1.displayProfile();
          // r2.displayProfile();

          // Q9
          // SystemConfiguration sc1 = new SystemConfiguration("cache_config_value");
          // SystemConfiguration sc2 = new SystemConfiguration(null);
          // sc1.getConfig();
          // sc2.getConfig();

          // Q10
          InsuranceClaim ic1 = new InsuranceClaim("Emergency fund!");
          InsuranceClaim ic2 = new InsuranceClaim(null);
          ic1.getNotes();
          ic2.getNotes();
     }    
}