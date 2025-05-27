import java.sql.*;

public class AccountDAO {
    private static final String URL = "jdbc:sqlite:bank.db";

    public void transfer(int fromAccountId, int toAccountId, double amount) {
        String debitSQL = "UPDATE accounts SET balance = balance - ? WHERE id = ?";
        String creditSQL = "UPDATE accounts SET balance = balance + ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL)) {
            conn.setAutoCommit(false); // Start transaction

            try (PreparedStatement debitStmt = conn.prepareStatement(debitSQL);
                 PreparedStatement creditStmt = conn.prepareStatement(creditSQL)) {

                // Debit from sender
                debitStmt.setDouble(1, amount);
                debitStmt.setInt(2, fromAccountId);
                int debitResult = debitStmt.executeUpdate();

                // Credit to receiver
                creditStmt.setDouble(1, amount);
                creditStmt.setInt(2, toAccountId);
                int creditResult = creditStmt.executeUpdate();

                // Validate both updates
                if (debitResult == 1 && creditResult == 1) {
                    conn.commit();
                    System.out.println("Transaction successful.");
                } else {
                    conn.rollback();
                    System.out.println("Transaction failed. Rolled back.");
                }

            } catch (SQLException e) {
                conn.rollback();
                System.out.println("Error occurred. Rolled back. " + e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("Database connection error: " + e.getMessage());
        }
    }
}
