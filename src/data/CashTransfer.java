package data;

import gui.CashTransferGUI;

import javax.swing.*;
import java.sql.*;

import static data.CheckBalance.checkBalance;

public class CashTransfer {
    private static double balanceFromAnotherUser;

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

    public static boolean cashTransfer(User user, double cashTransferAmount, int accountID, String name) {
        try {
            if (transferCheck(accountID, name)) {

                String sql1 = "UPDATE balance SET amount = ? WHERE user_id = ?";
                PreparedStatement statement1 = connection.prepareStatement(sql1);
                statement1.setDouble(1, checkBalance(user) - cashTransferAmount);
                statement1.setInt(2, user.getId());
                statement1.executeUpdate();
                System.out.println("balance deducted for transfer.");

                String sql2 = "UPDATE balance SET amount = ? WHERE user_id = ?";
                PreparedStatement statement2 = connection.prepareStatement(sql2);
                statement2.setDouble(1, balanceFromAnotherUser + cashTransferAmount);
                statement2.setInt(2, accountID);
                statement2.executeUpdate();
                System.out.println("transferred");

                String sql3 = "INSERT INTO transactions (amount, name, date, account_id, transferToID, transferFromID) VALUES (?, ?, NOW(), ?, ?, ?)";
                PreparedStatement statement3 = connection.prepareStatement(sql3);
                statement3.setDouble(1, cashTransferAmount);
                statement3.setString(2, name);
                statement3.setInt(3, accountID);
                statement3.setInt(4, accountID);
                statement3.setInt(5, user.getId());
                statement3.executeUpdate();
                System.out.println("Transaction inserted successfully.");

                return true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    private static boolean transferCheck(int accountID, String name) {
        try {
            String sql = "SELECT balance.amount FROM balance INNER JOIN users ON balance.user_id = users.id WHERE name = ? AND user_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setInt(2, accountID);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                balanceFromAnotherUser = result.getDouble("amount");
                return true;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
