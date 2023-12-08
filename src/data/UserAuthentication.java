package data;

import java.sql.*;

public class UserAuthentication {
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

    public static boolean registration(String name, String email, String number, String password) {
        boolean isSuccesful;
        try {
            if (isExistingData(name, email, number)) {
                String sql = "INSERT INTO users (name, email, number, password) VALUES (?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(sql);

                statement.setString(1, name);
                statement.setString(2, email);
                statement.setString(3, number);
                statement.setString(4, password);
                statement.executeUpdate();

                isSuccesful = true;
            } else {
                isSuccesful = false;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isSuccesful;
    }

    private static boolean isExistingData(String name, String email, String number) {
        boolean isValid;
        try {
            String sql = "SELECT 1 FROM users WHERE name = ? OR email = ? OR number = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, number);
            ResultSet result = statement.executeQuery();

            isValid = !result.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isValid;
    }

    public static void setPIN(String name, String email, String number, String pin) {
        try {
            String sql = "UPDATE users SET pin = ? WHERE number = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, pin);
            statement.setString(2, number);
            statement.executeUpdate();

            System.out.println("PIN has been set!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void logIn() {

    }

    public static void changePIN() {

    }

    public static void logOut() {

    }
}
