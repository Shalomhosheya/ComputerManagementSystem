package lk.Ijse.Dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {
    private static Dbconnection dbconnection;
    private Connection connection;

    private Dbconnection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/computerManagement","root","shalom@12344321");
    }
    public static Dbconnection getDbconnection() throws SQLException {
        return(dbconnection==null)?new Dbconnection():dbconnection;
    }
    public Connection getConnection(){
        return connection;
    }
}
