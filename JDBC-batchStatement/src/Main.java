import java.sql.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaworld", "javauser", "java1234")) {

            Statement stmt = conn.createStatement();

            String sql1 = "INSERT INTO city(Name,CountryCode,District,Population) VALUES ('Chania','GRC','Crete',100000)";
            String sql2 = "INSERT INTO city(Name,CountryCode,District,Population) VALUES ('Rethymno','GRC','Crete',50000)";

            stmt.addBatch(sql1);
            stmt.addBatch(sql2);

            System.out.println(Arrays.toString(stmt.executeBatch()));

            stmt.close();



      }
        catch (SQLException e) {
            System.out.println(e);
        }
    }
}

