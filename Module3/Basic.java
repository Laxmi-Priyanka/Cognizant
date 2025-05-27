import java.sql.*;

public class SQLiteJDBCExample {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:students.db"; // Path to SQLite DB file

        try {
            // Load JDBC driver (optional for newer JDBC versions)
            Class.forName("org.sqlite.JDBC");

            // Establish connection
            Connection conn = DriverManager.getConnection(url);
            System.out.println("Connection established.");

            // Create and execute query
            String query = "SELECT * FROM students";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            // Process results
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");

                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
            }

            // Clean up
            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("SQLite JDBC driver not found.");
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
