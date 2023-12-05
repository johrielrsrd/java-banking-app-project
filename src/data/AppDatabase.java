package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AppDatabase {
    static String DB_URL = "jdbc:mysql://127.0.0.1:3306/bankappdata";
    static String DB_USERNAME = "root";
    static String DB_PASSWORD = "test123";
    static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void test() {

    }


}
