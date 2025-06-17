package com.studentmanagement.app;

import com.google.gson.Gson;

import java.sql.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StudentManagement {

    private static final Logger logger = LogManager.getLogger();

    Connection con;

    StudentManagement() {
        connectDB();
    }

    void connectDB() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb", "root", "admin");
            logger.info("Connected to database.");

            DatabaseMetaData dbm = con.getMetaData();
            ResultSet tables = dbm.getTables(null, null, "students", null);

            if(!tables.next()) {
                logger.info("Table 'students' doesn't exists. Creating...");
                String query = "CREATE TABLE students(id INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                        "name VARCHAR(25) NOT NULL," +
                        "uid VARCHAR(10) NOT NULL," +
                        "phone VARCHAR(20) NOT NULL" +
                        " );";
                PreparedStatement pst = con.prepareStatement(query);
                pst.executeUpdate();
                logger.info("Table 'students' created.");
            } else {
                logger.info("Table 'students' already exists.");
            }
        } catch(SQLException e) {
            logger.error("Database connection or table creation failed: ", e);
            System.err.println("Database connection or table creation failed: " + e.getMessage());
        }
    }

    void addStudent(String uid, String name, String phone) {

        try {
            String query = "INSERT INTO students(name, uid, phone) VALUES(?, ?, ?);";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, uid);
            pst.setString(3, phone);
            pst.executeUpdate();
            logger.info("Student added - UID: {}, Name: {}", uid, name);
            System.out.println("Student details added successfully!");
        } catch(SQLException e) {
            logger.error("Failed to add student - UID: {} ", uid, e);
            System.err.println("Failed to add student - UID: " + uid);
        }
    }

    void viewStudent() {

        try {
            String query = "SELECT name, uid, phone FROM students;";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            Gson gson = new Gson();

            while(rs.next()) {
                Student s = new Student();
                s.setName(rs.getString("name"));
                s.setUid(rs.getString("uid"));
                s.setPhone(rs.getString("phone"));
                String ss = gson.toJson(s);
                System.out.println(ss);
            }
            logger.info("Displayed all student records.");
        } catch(SQLException e) {
            logger.error("Failed to retrieve student records", e);
            System.err.println("Failed to retrieve student records: " + e.getMessage());
        }
    }
}
