package service;

import config.DBConfig;
import service.HistoryService;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BackupService {
    public static void backupDatabase(String databaseName) {

        try {
            File backupDir = new File("backups"); // It Creates backups folder
            if (!backupDir.exists()) {
                backupDir.mkdir();
            }

            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String backupFile = "backups/" + databaseName + "_" + timestamp + ".sql";

            String command = "\"" + DBConfig.MYSQLDUMP_PATH + "\" " +
                            "-u " + DBConfig.USERNAME +
                            " -p" + DBConfig.PASSWORD +
                            " " + databaseName +
                            " -r \"" + backupFile + "\"";

            Process process = Runtime.getRuntime().exec(command);
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                System.out.println("\nBackup Successful!");
                System.out.println("Saved at: " + backupFile);
                HistoryService.saveBackupHistory(databaseName, backupFile,"SUCCESS");
            } else {
                System.out.println("\nBackup Failed!");
                HistoryService.saveBackupHistory(databaseName, backupFile,"FAILED");
            }
        } catch (Exception e) {
            System.out.println("Backup Error!");
            e.printStackTrace();
        }
    }
}