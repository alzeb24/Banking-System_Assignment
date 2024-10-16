package task14.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/hmbank"; // Change as needed
    private static final String USER = "root";
    private static final String PASSWORD = "@lzebKhan1";

    public static Connection getDBConn() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace(); // Handle exception appropriately
        }
        return conn;
    }
}

