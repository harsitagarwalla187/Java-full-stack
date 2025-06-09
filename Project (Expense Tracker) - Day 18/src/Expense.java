import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Expense {
    String userId;
    Scanner scan;
    Connection con;

    Expense(String userId) throws SQLException {
        this.userId = userId;
        scan = new Scanner(System.in);
        connectToDB("jdbc:mysql://localhost:3306/javadb", "root", "admin");
    }

    void connectToDB(String url, String username, String password) throws SQLException {
        con = DriverManager.getConnection(url, username, password);
        System.out.println("Database Connection Successful!");
        createTable();
    }

    void createTable() throws SQLException {

        Statement st = con.createStatement();
        String query = "CREATE TABLE IF NOT EXISTS expenses ("
                + "id INT PRIMARY KEY AUTO_INCREMENT, "
                + "user_id VARCHAR(150), "
                + "category_name VARCHAR(150), "
                + "price INT, "
                + "expense_date DATE, "
                + "FOREIGN KEY (user_id) REFERENCES users(id)"
                + ");";

        if(st.executeUpdate(query) >= 0) {
            System.out.println("Table created successfully!");
        } else {
            System.out.println("Something went wrong! ");
        }
    }

    void addExpense() throws SQLException {
        System.out.print("Product Name: ");
        String productName = scan.nextLine();

        System.out.print("Product Price: ");
        int productPrice = scan.nextInt();
        scan.nextLine();

        LocalDate date = LocalDate.now();

        String query = "INSERT INTO expenses(user_id, category_name, price, expense_date) VALUES (?, ?, ?, ?)";
        PreparedStatement pst = con.prepareStatement(query);

        try {
            pst.setString(1, userId);
            pst.setString(2, productName);
            pst.setInt(3, productPrice);
            pst.setDate(4, java.sql.Date.valueOf(date));

            int rows = pst.executeUpdate();
            if (rows > 0) {
                System.out.println("Expense added successfully!");
            } else {
                System.out.println("Failed to add expense.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void viewExpense() throws SQLException {
        String query = "SELECT id, category_name, price, expense_date FROM expenses WHERE user_id = ? ORDER BY expense_date DESC";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, userId);

        ResultSet rs = pst.executeQuery();

        System.out.println("Your Expenses:");
        System.out.println("ID      Category        Price       Date");

        boolean hasExpenses = false;
        while (rs.next()) {
            hasExpenses = true;
            int id = rs.getInt("id");
            String category = rs.getString("category_name");
            int price = rs.getInt("price");
            Date date = rs.getDate("expense_date");

            System.out.println(id + "   " + category + "   " + price + "   " + date.toString());
        }

        if (!hasExpenses) {
            System.out.println("No expenses found.");
        }
    }

    void deleteExpense() throws SQLException {
        System.out.print("Enter Expense ID to delete: ");
        int expenseId = scan.nextInt();
        scan.nextLine();

        String checkQuery = "SELECT id FROM expenses WHERE id = ? AND user_id = ?";
        PreparedStatement checkPst = con.prepareStatement(checkQuery);
        checkPst.setInt(1, expenseId);
        checkPst.setString(2, userId);

        ResultSet rs = checkPst.executeQuery();
        if (!rs.next()) {
            System.out.println("Expense not found!");
            return;
        }

        String deleteQuery = "DELETE FROM expenses WHERE id = ? AND user_id = ?";
        PreparedStatement deletePst = con.prepareStatement(deleteQuery);
        deletePst.setInt(1, expenseId);
        deletePst.setString(2, userId);

        int rows = deletePst.executeUpdate();
        if (rows > 0) {
            System.out.println("Expense deleted successfully!");
        } else {
            System.out.println("Failed to delete expense.");
        }
    }

    void updateExpense() throws SQLException {
        System.out.println("Enter the product Id to update:");
        int productId = scan.nextInt();

        String query = "Select * FROM expenses WHERE user_id = ? AND id = ?;";

        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, userId);
        pst.setInt(2, productId);

        ResultSet rs = pst.executeQuery();

        if(rs.next()) {
            updateProductDetails();
        } else {
            System.out.println("Product doesn't exists");
        }
    }

    void updateProductDetails() {

        boolean flag = true;
        do {
            System.out.println("Select one:");
            System.out.println("1. Update Product Name.");
            System.out.println("2. Update Product Price.");
            System.out.println("3. Exit");
            int option = scan.nextInt();

            switch(option) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Do yo");
            }
        } while(flag);
    }
}
