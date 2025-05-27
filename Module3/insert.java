import java.sql.*;

public class StudentDAO {
    private static final String URL = "jdbc:sqlite:students.db";

    // Insert new student
    public void insertStudent(String name, int age) {
        String sql = "INSERT INTO students(name, age) VALUES(?, ?)";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            int rows = pstmt.executeUpdate();
            System.out.println("Inserted " + rows + " student(s).");

        } catch (SQLException e) {
            System.out.println("Insert Error: " + e.getMessage());
        }
    }

    // Update existing student
    public void updateStudent(int id, String name, int age) {
        String sql = "UPDATE students SET name = ?, age = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setInt(3, id);
            int rows = pstmt.executeUpdate();
            System.out.println("Updated " + rows + " student(s).");

        } catch (SQLException e) {
            System.out.println("Update Error: " + e.getMessage());
        }
    }
}
