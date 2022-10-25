import java.io.*;
import java.sql.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaworld","javauser","java1234")) {

            String sql = "INSERT INTO city(Name,CountryCode,District,Population) VALUES (?,?,?,?)";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1,"Chania");
            stmt.setString(2,"GRC");
            stmt.setString(3,"Crete");
            stmt.setLong(4,100000);
            stmt.addBatch();
            stmt.setString(1,"Rethymno");
            stmt.setLong(4,50000);
            stmt.addBatch();

            System.out.println(Arrays.toString(stmt.executeBatch()));

            stmt.close();
        } catch(SQLException e) {
            System.out.println(e);
        }
    }
}

