package MyPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnection {

    public static void main(String[] args) {

        try {
//            Class.forName("com.mysql.cj.jdbc.Driver"); // Deprecated now
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb", "root", "admin");

            if(con != null) {
                System.out.println(con);
                System.out.println("Connection Successful!");
            } else {
                System.out.println("Connection failed!");
            }

            Statement st = con.createStatement();
            String query = "CREATE TABLE IF NOT EXISTS user(id int primary key auto_increment, name varchar(50) not null, email varchar(50) not null, password varchar(50) not null);";

            if(st.executeUpdate(query) >= 0) {
                System.out.println("Table created successfully!");
            } else {
                System.out.println("Something went wrong! ");
            }

            String insert1 = "INSERT INTO user(name, email, password) VALUES('Alice', 'alice@example.com', 'alice123');";
            String insert2 = "INSERT INTO user(name, email, password) VALUES('Bob', 'bob@example.com', 'bob456');";
            String insert3 = "INSERT INTO user(name, email, password) VALUES('Charlie', 'charlie@example.com', 'charlie789');";

            int rowsInserted = 0;
            rowsInserted += st.executeUpdate(insert1);
            rowsInserted += st.executeUpdate(insert2);
            rowsInserted += st.executeUpdate(insert3);

            System.out.println(rowsInserted + " rows inserted successfully.");

            String selectQuery = "SELECT * FROM user";
            ResultSet rs = st.executeQuery(selectQuery);

            System.out.println("ID\tName\t\t\tEmail\t\t\tPassword");
            System.out.println("---------------------------------------------------------");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");

                System.out.println(id + "\t" + name + "\t\t" + email + "\t" + password);
            }

            con.close();
        } catch(Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

    }
}

// Prepared Statement