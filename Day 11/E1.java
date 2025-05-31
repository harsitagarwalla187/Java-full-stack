import java.util.ArrayList;
import java.util.Arrays;

public class E1 {
     static void isValidEmail(String emailId) {
          char[] arr = emailId.toCharArray();
          int count = 0;
          for(int i=0; i<arr.length; i++) {
               if(arr[i] == '@') {
                    count++;
               }
          }
          if(count > 1 || count < 1) {
               System.out.println(false);
          } else {
               boolean s1 = emailId.substring(0, emailId.indexOf("@")).length() > 0;
               boolean s2 = emailId.substring(emailId.indexOf("@")+1).equals("gmail.com");

               System.out.println(s1 == s2);
          }
     }

     static void getFileExtension(String file) {

          int index = file.lastIndexOf(".");

          if( index == -1) {
               System.out.println("No Extension!");
          } else {
               System.out.println(file.substring(index));
          }
     }

     static void usernameSanitization(String name) {
          String sanitizedName = name.toLowerCase().replace(" ", "_");
          System.out.println(sanitizedName);
     }

     static void detectProfanity(String input, ArrayList<String> badWords) {
          String[] words = input.split(" |,|!");

          for(int i=0 ;i<words.length; i++) {
               for(String j:badWords) {
                    if(words[i].equals(j)) {
                         System.out.println(true);
                         return;
                    }
               }
          }
          System.out.println(false);
     }

     static void countWords(String sentence) {

          ArrayList<String> words = new ArrayList<>(Arrays.asList(sentence.split(" ")));

          int count = 0;
          for(String i:words) {
               if(i.length() != 0) {
                    count++;
               }
          }

          System.out.println(count);
     }

     static void isPasswordSecure(String password) {
          boolean contains = password.contains("@");
          char lastChar = password.charAt(password.length()-1);
          boolean endsWithDigit = (lastChar >= 48 && lastChar <= 57) ? true : false; 
          int count = 0;
          for(int i=0; i<password.length(); i++) {
               if((password.charAt(i) >= 65 && password.charAt(i) <= 90) || (password.charAt(i) >= 97 && password.charAt(i) <= 122)) {
                    count++;
               }
          }
          boolean hasEight = (count >= 8);

          System.out.println(hasEight && endsWithDigit && contains);  
     }

     static void isValidURL(String url) {
          boolean check = url.startsWith("https://");
          System.out.println(check);
     }

     static void compareNames(String s1, String s2) {
          boolean check = s1.equalsIgnoreCase(s2);
          System.out.println(check);
     }

     static void findInitials(String fullName) {
          String initials = "";
          ArrayList<String> words = new ArrayList<>(Arrays.asList(fullName.split(" ")));
          for(String word:words) {
               initials += word.charAt(0);
          }
          System.out.println(initials);
     }

     static void maskDigits(String cardNum) {
          String maskedDigits = "";
          for(int i=0; i<cardNum.length()-4; i++) {
               if(cardNum.charAt(i) == ' ') {
                    maskedDigits += " ";
               } else {{
                    maskedDigits += "*";
               }}
          }
          maskedDigits += cardNum.substring(cardNum.length()-4);
          System.out.println(maskedDigits);
     }

     public static void main(String[] args) {

          // Q1
          isValidEmail("hrsit@gmail.com");
          isValidEmail("hrsit@gmail@.com");
          isValidEmail("@gmail.com");
          isValidEmail("hrsit@");
          System.out.println("*****************************************************");

          //Q2
          getFileExtension("report.final.pdf");
          getFileExtension("archive.tar.gz");
          getFileExtension("file");
          System.out.println("*****************************************************");

          // Q3
          usernameSanitization("John Doe");
          usernameSanitization("ADMIN User");
          System.out.println("*****************************************************");

          // Q4
          detectProfanity("You are an idiot!",new ArrayList<>(Arrays.asList("idiot", "dumb")));
          detectProfanity("Great job, well done!",new ArrayList<>(Arrays.asList("idiot", "dumb")));
          System.out.println("*****************************************************");

          // Q5
          countWords("  Hello   world!  ");
          countWords("Java is awesome");
          System.out.println("*****************************************************");

          // Q6
          isPasswordSecure("Pass@123");
          isPasswordSecure("Password@123");
          isPasswordSecure("1234567@");
          isPasswordSecure("pass@word");
          System.out.println("*****************************************************");

          // Q7
          isValidURL("https://google.com");
          isValidURL("http://example.com");
          System.out.println("*****************************************************");

          // Q8
          compareNames("Alice", "alice");
          compareNames("Bob", "Bobby");
          System.out.println("*****************************************************");

          // Q9
          findInitials("John Ronald Reuel Tolkien");
          findInitials("Ada Lovelace");
          System.out.println("*****************************************************");

          // Q10
          maskDigits("1234 5678 9012 3456");
          maskDigits("9876 5432 1098 7654");
     }
}