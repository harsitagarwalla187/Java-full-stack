import java.util.Scanner;

interface FirstTimeUser {
     double discount(double amt);
}

interface FestiveOffer {
     double discount(double amt);
}

interface PremiumMember {
     double discount(double amt);
}

public class E4 {
     public static void main(String[] args) {

          Scanner scan = new Scanner(System.in);

          FirstTimeUser ftu = (double amt) -> amt - amt * 0.1;
          FestiveOffer fo = (double amt) -> amt - 100;
          PremiumMember pm = (double amt) -> {
               if(amt > 2000) {
                    return amt - amt * 0.15;
               } else {
                    return amt;
               }
          };

          boolean flag = true;
          do {

               System.out.println("---------------------------------------");
               System.out.println("Enter the amount!");
               double amount = scan.nextDouble();

               System.out.println("Enter offer type:");
               System.out.println("1. First time user");
               System.out.println("2. Festive Offer");
               System.out.println("3. Premium User");
               int in = scan.nextInt();

               switch(in) {
                    case 1: System.out.println("Offer price: " + ftu.discount(amount));
                            break;
                    case 2: System.out.println("Offer price: " + fo.discount(amount));
                            break;
                    case 3: System.out.println("Offer price: " + pm.discount(amount));
                            break;
                    case 4: flag = false;
                            break;
                    default: System.out.println("Wrong Input! \nSelect(1, 2, 3 or 4)");
               } 

               if(!flag) return;
               System.out.println("---------------------------------------");
               System.out.println("Do you want to continue? (Y/N)");
               char ch = scan.next().charAt(0);
               if(ch == 'N' || ch == 'n') {
                    flag = false;
               }
               System.out.println("---------------------------------------");

          } while(flag);

     }
}