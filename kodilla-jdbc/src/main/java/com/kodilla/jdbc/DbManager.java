package com.kodilla.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbManager {
    private Connection conn;
    private static DbManager dbManagerInstance;

    private DbManager(String db) throws SQLException{
        Properties connectionProps= new Properties();
        connectionProps.put("user", "kodilla_user");
        connectionProps.put("password", "kodilla_password");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db + "?serverTimezone=Europe/Warsaw" +
                "&useSSL=False", connectionProps);
    }

    public static DbManager getInstance(String db) throws SQLException{
        if(dbManagerInstance == null){
            dbManagerInstance = new DbManager(db);
        }
        return dbManagerInstance;
    }

    public Connection getConnection() {
        return conn;
    }
}
