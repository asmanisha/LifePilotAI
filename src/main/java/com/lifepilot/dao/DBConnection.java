/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lifepilot.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    
    public static Connection getConnection()throws SQLException {
        
            Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/lifepilot_db", "root", "root");
            return connection;
        
    }
    
}
