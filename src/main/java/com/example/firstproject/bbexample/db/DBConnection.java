package com.example.firstproject.bbexample.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.example.firstproject.bbexample.constans.DBConstans.*;


public enum DBConnection {
    INSTANCE;
    private Connection connection;

    public Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection("jdbc:postgresql://" + DB_HOST + ":"
            + PORT + "/" + DB, USER, PASSWORD);
        }
        return connection;
    }
}
