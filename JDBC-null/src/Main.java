import java.sql.*;

public class Main {

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaworld", "javauser", "java1234")) {

            //Select
            Statement stmt = conn.createStatement();

            String sql = "SELECT IndepYear FROM country WHERE name = 'Aruba' OR name = 'Afghanistan'";

            ResultSet result = stmt.executeQuery(sql);

            result.next();

            Integer year = (Integer)result.getObject("IndepYear");

            System.out.println(year);

            result.next();

            year = (Integer)result.getObject("IndepYear");

            System.out.println(year);

            stmt.close();
            result.close();

            //Insert
            String sql2 = "INSERT INTO country (Code, Name, Continent, Region, SurfaceArea, IndepYear, Population, LocalName, GovernmentForm, Code2) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pr = conn.prepareStatement(sql2);

            pr.setString(1, "WAD");
            pr.setString(2, "Wakanda");
            pr.setString(3, "Africa");
            pr.setString(4, "Wakaha");
            pr.setDouble(5, 1234.012);
            pr.setObject(6, null);
            pr.setLong(7, 234);
            pr.setString(8, "WAK");
            pr.setString(9, "WAK");
            pr.setString(10, "WA");

            pr.executeUpdate();

            pr.close();
        }
        catch (SQLException e) {
            System.out.println(e);
        }
    }
}
