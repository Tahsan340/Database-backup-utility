package database;

import config.DBConfig;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(
                    DBConfig.URL,
                    DBConfig.USERNAME,
                    DBConfig.PASSWORD
            );
            return connection;

        } catch (SQLException e) {
            System.out.println("Database Connection Failed!");
            e.printStackTrace();
            return null;
        }
    }
}