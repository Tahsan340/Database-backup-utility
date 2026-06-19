# Database Backup Utility (Java + MySQL)

## Features
- Show all MySQL databases
- Backup database to .sql file
- Restore database from backup
- Backup history tracking

## Tech Stack
- Java (Core + JDBC)
- MySQL
- File Handling
- Process Execution (mysqldump, mysql)

## How it works
1. User selects database
2. System creates backup using mysqldump
3. Stores backup file locally
4. Logs history into MySQL table
5. Restore reads .sql file and executes queries

## Author
Built as a learning project to master Java backend development.

## Project URL
https://roadmap.sh/projects/database-backup-utility
