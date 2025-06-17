package com.studentmanagement.app;

import java.sql.SQLException;

public class App {
    public static void main( String[] args ) throws SQLException
    {
        StudentDB s1 = new StudentDB();
        s1.addStudent("2121312", "Harsit Agarwalla", "1234567893");
        s1.viewStudent();

        boolean flag = true;

        do {

        } while(flag);
        System.out.println("Thank you!");
    }
}
