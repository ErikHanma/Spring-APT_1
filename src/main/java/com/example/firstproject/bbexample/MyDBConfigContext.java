package com.example.firstproject.bbexample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import static com.example.firstproject.bbexample.constans.DBConstans.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class MyDBConfigContext {
    @Bean
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:postgresql://"
                + DB_HOST + ":"
                + PORT + "/"
                + DB, USER, PASSWORD
        );

    }
}
