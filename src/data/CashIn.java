package data;

import java.sql.*;

import static data.CheckBalance.checkBalance;

public class CashIn {
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

    public static void cashIn(User user, double cashInAmount) {
        try {
            String sql = "UPDATE balance SET amount = ? WHERE user_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDouble(1, checkBalance(user) + cashInAmount);
            statement.setInt(2, user.getId());
            statement.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
