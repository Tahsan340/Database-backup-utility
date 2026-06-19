package service;

import database.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HistoryService {
    public static void showHistory() {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "SELECT * FROM backup_history ORDER BY backup_time DESC";

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            System.out.println("\n===== BACKUP HISTORY =====");

            while (rs.next()) {
                int id = rs.getInt("id");
                String dbName = rs.getString("database_name");
                String filePath = rs.getString("file_path");
                String time = rs.getString("backup_time");
                String status = rs.getString("status");

                System.out.println(id + " | " + dbName + " | " + filePath + " | " + time + " | " + status);
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Failed to fetch history!");
            e.printStackTrace();
        }
    }

    public static void saveBackupHistory(String dbName, String filePath, String status) {
        try {

            Connection conn = DBConnection.getConnection();
            String sql = "INSERT INTO backup_history (database_name, file_path, status) VALUES (?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, dbName);
            ps.setString(2, filePath);
            ps.setString(3, status);

            ps.executeUpdate();
            ps.close();
            conn.close();

            System.out.println("History saved!");

        } catch (Exception e) {
            System.out.println("Failed to save history");
            e.printStackTrace();
        }
    }
}
