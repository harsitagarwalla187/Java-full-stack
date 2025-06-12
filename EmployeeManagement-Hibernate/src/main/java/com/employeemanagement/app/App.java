package com.employeemanagement.app;

import com.employeemanagement.app.defination.EmployeeHandler;
import com.employeemanagement.app.entity.Admin;
import com.employeemanagement.app.utility.Sessions;
import org.hibernate.Session;

import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        Sessions sessions = new Sessions();
        Session session = sessions.getSession();
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome Admin!");
        System.out.print("Enter your username: ");
        String adminUsername = scan.nextLine();
        System.out.print("Enter you password: ");
        String adminPassword = scan.nextLine();

        Admin admin = session.get(Admin.class, 1);
        if(admin == null) {
            System.out.println("Admin not found!");
            return;
        }

        if(admin.getPassword().equals(adminPassword) && admin.getUsername().equals(adminUsername)) {
            boolean flag = true;

            do {
                System.out.println("Select one:");
                System.out.println("1. Add Employee");
                System.out.println("2. Show All Employee");
                System.out.println("3. Delete Employee");
                System.out.println("4. Exit");
                int option = scan.nextInt();
                scan.nextLine();

                EmployeeHandler emh = new EmployeeHandler();

                switch (option) {
                    case 1: emh.addEmployee();
                        break;
                    case 2: emh.showEmployees();
                        break;
                    case 3: emh.deleteEmployee();
                        break;
                    case 4:
                        flag = false;
                        break;
                    default:
                        System.out.println("Do you want to continue?(Y/N)");
                        char c = scan.nextLine().charAt(0);
                        flag = (c == 'Y' || c == 'y');
                }
            } while(flag);
            System.out.println("Exited!");
        } else {
            System.out.println("Wrong Credentials!");
        }

        session.close();
        sessions.closeFactory();
    }
}
