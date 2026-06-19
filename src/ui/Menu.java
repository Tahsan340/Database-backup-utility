package ui;
import service.BackupService;
import service.DatabaseService;
import java.util.Scanner;

import service.HistoryService;
import service.RestoreService;
public class Menu {
    public static void start() {

        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n===== DATABASE BACKUP UTILITY =====");
            System.out.println("1. Show All Databases");
            System.out.println("2. Backup Database");
            System.out.println("3. Restore Database");
            System.out.println("4. View Backup History");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    DatabaseService.showAllDatabases();
                    break;

                case 2:
                    System.out.print("Enter database name: ");
                    String dbName = sc.nextLine();
                    BackupService.backupDatabase(dbName);
                    break;

                case 3:
                    System.out.print("Enter backup file path: ");
                    String path = sc.nextLine().trim();
                    RestoreService.restoreDatabase(path);
                    break;

                case 4:
                    HistoryService.showHistory();
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 2);
        sc.close();
    }
}