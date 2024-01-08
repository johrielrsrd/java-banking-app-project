package data;

import java.sql.*;

public class CheckBalance {
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

    public static double checkBalance(User user) {
        try {
            String sql = "SELECT balance.amount FROM balance INNER JOIN users ON balance.user_id = users.id WHERE user_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, user.getId());
            ResultSet result = statement.executeQuery();

            if (result.next()) {

                return result.getDouble("amount");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
}
