package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {

    public static Connection getConnection() throws SQLException {

        try {
            Class.forName("org.postgresql.Driver"); //searching for the postgres driver, which we have as a dependency
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); //This tells in the console us what went wrong
            System.out.println("problem occurred locating driver");
        }
        String url="jdbc:postgresql://localhost:5432/postgres?currentSchema=project0";
        String username="postgres";
        String password="password";



        return DriverManager.getConnection(url, username, password);
    }
}
