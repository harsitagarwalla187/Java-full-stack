import java.sql.*;
import java.util.Scanner;

public class User {
    String name, password, email;
    Scanner scan;
    Connection con;

    User() throws SQLException {
        scan = new Scanner(System.in);
        name = "";
        password = "";
        email = "";
        connectToDB("jdbc:mysql://localhost:3306/javadb", "root", "admin");
    }

    void connectToDB(String url, String username, String password) throws SQLException {
        con = DriverManager.getConnection(url, username, password);
        System.out.println("Database Connection Successful!");
        createTable();
    }

    void createTable() throws SQLException {

        Statement st = con.createStatement();
        String query = "CREATE TABLE IF NOT EXISTS users(id varchar(150) primary key, name varchar(150) not null, email varchar(150) not null, password varchar(150) not null);";

        if(st.executeUpdate(query) >= 0) {
            System.out.println("Table created successfully!");
        } else {
            System.out.println("Something went wrong! ");
        }
    }

    void register() throws SQLException {
        System.out.println("Enter your details:");
        System.out.print("Enter you name: ");
        name = scan.nextLine();
        System.out.print("Enter you email: ");
        email = scan.nextLine();
        System.out.print("Enter you password: ");
        password = scan.nextLine();
        addUser(name, email, password);
    }

    void login() throws SQLException {
        System.out.println("Enter your details:");
        System.out.print("Enter you email: ");
        email = scan.nextLine();
        System.out.print("Enter you password: ");
        password = scan.nextLine();
        if(validateUser(email, password)) {
            System.out.println("Login Successful!");
            goToExpense();
        } else {
            System.out.println("Invalid credentials!");
        }
    }

    void goToExpense() throws SQLException{
        Expense exp = new Expense(email);
        boolean flag = true;

        do {

            System.out.println("Select an option:");
            System.out.println("1. Add expense");
            System.out.println("2. View expense");
            System.out.println("3. Delete expense");
            System.out.println("4. Update expense");
            System.out.println("5. Exit");

            int option = scan.nextInt();
            scan.nextLine();

            switch (option) {
                case 1: exp.addExpense();
                    break;
                case 2: exp.viewExpense();
                    break;
                case 3: exp.deleteExpense();
                    break;
                case 4:exp.updateExpense();
                    break;
                case 5: flag = false;
                    break;
                default:
                    System.out.println("Do you want to continue?(Y/N)");
                    char ch = scan.nextLine().charAt(0);
                    flag = (ch == 'Y' || ch == 'y');
            }
        } while(flag);
    }

    boolean validateUser(String email, String password) throws SQLException {
        if(findUser(email)) {
            String query = "SELECT password FROM users WHERE email = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, email);

            ResultSet rs = pst.executeQuery();

            if(rs.next()) {
                String pswrd = rs.getString("password");
                if(pswrd.equals(password)) {
                    return true;
                }
            }

        }
        return false;
    }

    boolean findUser(String email) throws SQLException {
        boolean userExists = false;

        String query = "SELECT email FROM users WHERE email = ?";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, email);

        ResultSet rs = pst.executeQuery();

        if(rs.next()) {
            userExists = true;
        }

        return userExists;
    }

    void addUser(String name, String email, String password) throws SQLException {

        if(findUser(email)) {
            System.out.println("User already exists!");
            System.out.println("Redirects to Login...");
            login();
        } else {
            String insert = "INSERT INTO users(id, name, email, password) VALUES(?, ?, ?, ?);";
            PreparedStatement pst = con.prepareStatement(insert);
            pst.setString(1, email);
            pst.setString(2, name);
            pst.setString(3, email);
            pst.setString(4, password);

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("User inserted successfully!");
            } else {
                System.out.println("Insertion failed.");
            }
        }
    }
}