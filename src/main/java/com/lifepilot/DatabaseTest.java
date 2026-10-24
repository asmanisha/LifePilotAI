package com.lifepilot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseTest {
    
    public static void main(String[] args) {

        String url ="jdbc:mysql://localhost:3306/lifepilot_db";

        String username = "root";

        String password = "root";

        try (Connection connection =DriverManager.getConnection(url, username, password)) {

            System.out.println("Connected to MySQL successfully!");

        } catch (SQLException e) {
            System.out.println("Database connection failed.");
            System.out.println(e.getMessage());
        }
    }
    
}
