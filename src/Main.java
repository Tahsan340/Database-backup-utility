import database.DBConnection;
import java.sql.Connection;
import service.DatabaseService;
import ui.Menu;
public class Main {
    public static void main(String[] args) {

//        Connection conn = DBConnection.getConnection();
//        DatabaseService.showAllDatabases();

//        if (conn != null) {
//            System.out.println("Connected Successfully.");
//        } else {
//            System.out.println("Connection Failed.");
//        }
        Menu.start();
    }
}