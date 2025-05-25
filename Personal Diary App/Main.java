import java.util.Scanner;

class Diary {

     String title, content, date;
     Scanner scan = new Scanner(System.in);

     void create() {
          System.out.println("Welcome to write your day!");
          System.out.println("What is the date today?");
          String todayDate = scan.nextLine();
          System.out.println("What will be the title?");
          String todayTitle = scan.nextLine();
          System.out.println("Write your thoughts below:");
          String todayContent = scan.nextLine();

          create(todayDate, todayTitle, todayContent);
     }

     void create(String date, String title, String content) {
          this.date = date;
          this.title = title;
          this.content = content;
     }

     void read() {
          System.out.println("Your " + date + "thoughts...");
          System.out.println(title + "\n");
          System.out.println(content + "\n");
     }

     void update(String val, String cont) {
          if(val.equals("title")) {
               this.title = cont;
          } else if(val.equals("date")) {
               this.date = cont;
          } else if(val.equals("content")) {
               this.content = cont;
          }
     }
}

class User {
     String name, emailId;
     private long password;
     Diary diaries[] = new Diary[100];
     int diaryPageCount = 0;
     Scanner scan = new Scanner(System.in);

     User(String name, String emailId, long password) {
          for(int i=0; i<100; i++) {
               diaries[i] = new Diary();
          }
          this.name = name;
          this.emailId = emailId;
          this.password = password;
     }

     void userAuthorised() {
          System.out.println("Welcome to your Diary! " + this.name);

          do {
               System.out.println("Select one option from below : ");    
               System.out.println("1. Write something new?");
               System.out.println("2. Read previous diary?");
               System.out.println("3. Update previous diary?");
               System.out.println("4. Delete previous diary?");

               int input = scan.nextInt();
               scan.nextLine();

               switch(input) {
                    case 1: createDiary();
                            break;
                    case 2: readDiary();
                            break;
                    case 3: updateDiary();
                            break;
                    case 4: deleteDiary();
                            break;
                    default: System.out.println("Invalid input!");
               }

               System.out.println("Do you want to continue(Y/N)?");
               char ch = scan.next().charAt(0);
               if(ch == 'n' || ch == 'N' ) {
                    System.out.println("Thank you!");
                    break;
               }
          } while(true);
     }

     void createDiary() {
          diaries[diaryPageCount].create();
          diaryPageCount++;
     }

     void readDiary() {
          System.out.println("Enter the diary date to read?");          
          String date = scan.nextLine();
          for(int i=0; i<diaryPageCount; i++) {
               if(diaries[i].date.equals(date)) {
                    System.out.println("................................................");
                    diaries[i].read();
                    System.out.println("................................................");
                    break;
               }
          }
     }

     void updateDiary() {
          do {
               System.out.println("Enter the date to be updated:");
               String updateDate = scan.nextLine();

               System.out.println("What do you want to update?");
               System.out.println("1. Title?");
               System.out.println("2. Content?");
               int input = scan.nextInt();
               scan.nextLine();

               switch(input) {
                    case 1:System.out.println("Enter the new title:");
                           String newTitle = scan.nextLine();
                           for(int i=0; i<diaryPageCount; i++) {
                              if(diaries[i].date.equals(updateDate)) {
                                   diaries[i].update("title", newTitle);
                              }
                           }
                           break;
                    case 2:System.out.println("Enter the new Content:");
                           String newContent = scan.nextLine();
                           for(int i=0; i<diaryPageCount; i++) {
                              if(diaries[i].date.equals(updateDate)) {
                                   diaries[i].update("content", newContent);
                              }
                           }
                           break;
                    default:
               }

               System.out.println("Do you want to continue(Y/N)?");
               char ch = scan.next().charAt(0);
               if(ch == 'n' || ch == 'N' ) {
                    break;
               }
          
          } while(true);
     }

     void deleteDiary() {
          System.out.println("Enter the diary date to delete?");          
          String date = scan.nextLine();
          for(int i=0; i<diaryPageCount; i++) {
               if(diaries[i].date.equals(date)) {
                    for (int j = i; j < diaryPageCount - 1; j++) {
                         diaries[j] = diaries[j + 1];
                    }
                    diaries[diaryPageCount - 1] = null;
                    diaryPageCount--;
                    System.out.println("Content deleted successfully!");
                    break;
               }
          }
     }
}

class Login {
     Scanner scan = new Scanner(System.in);
     private User users[] = new User[100];
     private int userCount = 0;

     Login() {
          login();
     }

     void login() {
          System.out.println("**************** Login **********************");
          System.out.println("Your email Id : ");
          String emailId = scan.nextLine();
          emailId = emailId.trim();
          System.out.println("Your Password : ");
          long password = scan.nextLong();
          login(emailId, password);
     }

     void login(String emailId, long password) {
          if(this.find(emailId)) {
               System.out.println("Your are logged in.");
               User user = this.getUser(emailId);
               user.userAuthorised();
               
          } else {
               System.out.println("You are not registered!");
               this.register();
          }
     }

     void register() {

          System.out.println("****************** Register form ************");
          System.out.println("Your name : ");
          scan.nextLine();
          String name = scan.nextLine();
          name = name.trim();
          System.out.println("Your email Id : ");
          String emailId = scan.nextLine();
          emailId = emailId.trim();
          System.out.println("Your Password : ");
          long password = scan.nextLong();
          scan.nextLine();

          this.register(name, emailId, password);

          System.out.println("You are registered successfully!");
          login();
     }

     void register(String name, String emailId, long password) {

          if(this.find(emailId)) {
               System.out.println("User already exists!");
               return ;
          }

          User newUser = new User(name, emailId, password);
          if(userCount >= 100 ) {
               System.out.println("New Users can't be registered!");
          } else {
               users[userCount] = newUser;
               userCount++;
          }
     }

     boolean find(String emailId) {
          for(int i=0; i<userCount; i++) {
               if(users[i].emailId.equals(emailId)) {
                    return true;
               }
          }
          return false;
     }

     User getUser(String emailId) {
          for(int i=0; i<userCount; i++) {
               if(users[i].emailId.equals(emailId)) {
                    return users[i];
               }
          }

          return null;
     }
}

public class Main {
     public static void main(String[] args) {
          
          System.out.println("****************************************************");
          System.out.println("               Welcome to My Diary                  ");
          System.out.println("****************************************************");

          Login log = new Login();

     }
}