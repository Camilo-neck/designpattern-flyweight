// src/implementacion/DatabaseConnection.java
package implementacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://ep-wandering-bonus-a4t5kpje-pooler.us-east-1.aws.neon.tech:5432/verceldb?sslmode=require";
    private static final String USER = "default";
    private static final String PASSWORD = "4VuLSglJbOM7";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}