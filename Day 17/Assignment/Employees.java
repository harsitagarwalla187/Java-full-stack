package Assignment;

import java.sql.*;

public class Employees {
    Connection con;

    Employees() throws SQLException {
        connectDB();
    }

    void connectDB() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/javadb";
        String username = "root";
        String password = "admin";

        con = DriverManager.getConnection(url, username, password);
        createTable();
    }


    void createTable() throws SQLException{
        DatabaseMetaData dbm = con.getMetaData();
        ResultSet tables = dbm.getTables(null, null, "employees", null);

        if(!tables.next()) {
            String query = "CREATE TABLE employees(id INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR(50) NOT NULL," +
                    "department VARCHAR(50) NOT NULL," +
                    "salary DOUBLE NOT NULL" +
                    " );";
            PreparedStatement pst = con.prepareStatement(query);
            pst.executeUpdate();
        }
    }
}
