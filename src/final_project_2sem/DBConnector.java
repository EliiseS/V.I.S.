package final_project_2sem;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {    
    private static final String USER = "VIS";  //with root access you can do whatever you want  
    private static final String PASS = "VillaWatt";
    private static final String DB = "villa_watt_inventory";
    private static final String URL = "jdbc:mysql://138.128.216.12";
    private static final String PORT = "3306";
    
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //  jdbc:mysql://localhost:3306/task
            String urlForConn = URL+":"+PORT+"/"+DB;
            System.out.println("Connecting to database");
            conn = DriverManager.getConnection(urlForConn, USER, PASS);
            System.out.println("Connected to database");
        } catch (Exception ex) {
            System.out.println("[ERR] "+ex.getMessage());
        }         
        return conn;
    }    
}
