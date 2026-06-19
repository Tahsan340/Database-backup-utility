package service;

import database.DBConnection;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseService {
    public static void showAllDatabases() {
        try {
            Connection conn = DBConnection.getConnection();

            if (conn == null) {
                System.out.println("Connection failed!");
                return;
            }

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SHOW DATABASES");
            System.out.println("\n=== DATABASE LIST ===");
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error fetching databases!");
            e.printStackTrace();
        }
    }
}
