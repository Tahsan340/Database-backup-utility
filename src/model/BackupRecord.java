package model;

public class BackupRecord {

    private String databaseName;
    private String filePath;
    private String status;

    public BackupRecord(String databaseName, String filePath, String status) {
        this.databaseName = databaseName;
        this.filePath = filePath;
        this.status = status;
    }

    public String getDatabaseName() { return databaseName; }
    public String getFilePath() { return filePath; }
    public String getStatus() { return status; }
}