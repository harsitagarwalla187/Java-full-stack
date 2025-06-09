import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        User user = new User();
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Expense Tracker.");
        boolean flag = true;

        do {
            System.out.println("Select one option:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            int option = scan.nextInt();
            scan.nextLine();

            switch (option) {
                case 1: user.register();
                    break;
                case 2: user.login();
                    break;
                case 3: flag = false;
                    break;
                default:
                    System.out.println("Invalid Option!");
                    System.out.println("Do you want to continue?(Y/N)");
                    char ch = scan.nextLine().charAt(0);
                    flag = (ch == 'Y' || ch == 'y');
            }
        } while(flag);

        System.out.println("Thank you!");
    }
}
