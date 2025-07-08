package repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    private static String url="jdbc:mysql://172.18.0.2:3306/parcinfo";
    private static String users= "root";
    private static String passeword= "root";
    private static Connection connectionBd;


    public static Connection connectionBd() throws SQLException{
        connectionBd=DriverManager.getConnection(url, users, passeword);
        return connectionBd;
    }
}
