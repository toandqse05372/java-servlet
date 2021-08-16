package quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionFactory {

    
    private static String dbUser = "sa";
    private static String dbPassword = "123456";
    private static String dbName = "Quiz";
    private static String portNumber = "1433";

    public static Connection createConnection() {
        Connection con = null;
        String dbURL = "jdbc:sqlserver://localhost:"+ portNumber +";databaseName="+dbName;
        try {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            } catch (ClassNotFoundException ex) {
                System.out.println("Error: unable to load driver class!");
                System.exit(1);
            }
            con = DriverManager.getConnection(dbURL, dbUser, dbPassword);
        } catch (SQLException sqe) {
            System.out.println("Error: While Creating connection to database");
            sqe.printStackTrace();
        }
        return con;
    }

}
