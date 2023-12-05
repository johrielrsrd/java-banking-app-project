package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AppDatabase {
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/bankappdata";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "test123";
    private static final Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void testRegister(String name, String email, int number, int pin) {
        try {
            String sql = "INSERT INTO users (name, email, number, pin) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, name);
            statement.setString(2, email);
            statement.setInt(3, number);
            statement.setInt(4, pin);
            statement.executeUpdate();

            System.out.println("Record created.");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
