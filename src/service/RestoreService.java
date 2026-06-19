package service;
import java.io.File;
import database.DBConnection;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.Statement;

public class RestoreService {
    public static void restoreDatabase(String filePath) {

        try {
            //To Get DB connection
            Connection conn = DBConnection.getConnection();
            if (conn == null) {
                System.out.println("Connection failed!");
                return;
            }
            Statement stmt = conn.createStatement();

            //Read SQL file
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            StringBuilder sql = new StringBuilder();
            String line;
            System.out.println("Restoring database...");

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("--") || line.isEmpty()) {
                    continue;
                }
                sql.append(line);

                if (line.endsWith(";")) {
                    try {
                        stmt.execute(sql.toString());
                    } catch (Exception e) {
                        System.out.println("Error executing: " + sql);
                        e.printStackTrace();
                    }
                    sql.setLength(0);
                }
            }
            reader.close();
            stmt.close();
            conn.close();
            System.out.println("Restore completed successfully!");

        } catch (Exception e) {
            System.out.println("Restore failed!");
            System.out.println("ERROR DETAILS:");
            e.printStackTrace();
        }
        System.out.println("PATH RECEIVED: " + filePath);
        File file = new File(filePath.trim());
        System.out.println("ABS PATH: " + file.getAbsolutePath());
        System.out.println("EXISTS? " + file.exists());
        System.out.println("CAN READ? " + file.canRead());
    }
}