package com.studentmanagement.app;

import java.sql.SQLException;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App
{
    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main( String[] args )
    {
        logger.info("Application started!");
        StudentManagement sm = new StudentManagement();
        Scanner scan = new Scanner(System.in);

        boolean flag = true;
        do {
            System.out.println("Select one below:");
            System.out.println("1. Add Student.");
            System.out.println("2. View Student.");
            System.out.println("3. Exit.");
            int option = scan.nextInt();
            scan.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Enter student details:");
                    System.out.print("Enter name: ");
                    String name = scan.nextLine();
                    System.out.print("Enter UID: ");
                    String uid = scan.nextLine();
                    System.out.print("Enter phone number: ");
                    String ph = scan.nextLine();
                    sm.addStudent(uid, name, ph);
                    break;
                case 2:sm.viewStudent();
                    break;
                case 3: flag = false;
                    break;
                default:
                    System.out.println("Do you want to continue?(Y/N)");
                    char ch = scan.nextLine().charAt(0);
                    flag = (ch == 'Y' || ch == 'y');
            }
        } while(flag);
        System.out.println("Thank You!");
        logger.info("Application closed!");
    }
}
