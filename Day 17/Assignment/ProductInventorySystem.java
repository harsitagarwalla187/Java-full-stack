package Assignment;

import java.sql.*;

public class ProductInventorySystem {
    Connection con;

    ProductInventorySystem() throws SQLException {
        connectDB();
    }

    void connectDB() throws SQLException{
        String url = "jdbc:mysql://localhost:3306/javadb";
        String username = "root";
        String password = "admin";

        con = DriverManager.getConnection(url, username, password);
        createTable();
    }

    void createTable() throws SQLException {
        DatabaseMetaData dbm = con.getMetaData();
        ResultSet tables = dbm.getTables(null, null, "products", null);

        if(!tables.next()) {
            String query = "CREATE TABLE products(id INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR(50) NOT NULL," +
                    "price DOUBLE NOT NULL," +
                    "quantity INT NOT NULL" +
                    " );";
            PreparedStatement pst = con.prepareStatement(query);
            pst.executeUpdate();
        }
    }

    void addProduct(String name, double price, int quantity) throws SQLException {
        String query = "INSERT INTO products(name, price, quantity)" +
                "VALUES(?, ?, ?);";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, name);
        pst.setDouble(2, price);
        pst.setInt(3, quantity);
        pst.executeUpdate();
        System.out.println("Product added successfully!");
    }

    void updateQuantity(String name, int quantity) throws SQLException {
        String query = "UPDATE products " +
                "SET quantity = ? " +
                "WHERE name = ?;";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1, quantity);
        pst.setString(2, name);
        pst.executeUpdate();
        System.out.println("Product updated successfully!");
    }

    void deleteProduct(String name) throws SQLException {
        String query = "DELETE FROM products WHERE name = ?;";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, name);
        pst.executeUpdate();
        System.out.println("Product deleted successfully!");
    }
}
