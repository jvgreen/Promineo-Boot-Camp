package com.promineo.week11.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
    private Connection conn;
    private final String Username = "root";
    private final String Password = "31Ack1ag00n";

    public Connection getConnection(String dbName) {
        try
        {
            String connString = "jdbc:mysql://localhost:3306/" + dbName;
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(connString, Username, Password);
                System.out.println("dbConnected");
            }

            return conn;
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
            return conn;
        }
    }
}
