package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    private static final String URL = "jdbc:postgresql://localhost:5433/assik3";
    private static final String USER = "postgres";
    private static final String PASSWORD = "4865";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            throw new RuntimeException("Database connection failed");
        }
    }
}

