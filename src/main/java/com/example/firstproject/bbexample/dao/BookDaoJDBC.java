package com.example.firstproject.bbexample.dao;

import com.example.firstproject.bbexample.db.DBConnection;
import com.example.firstproject.bbexample.model.Book;
import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;

public class BookDaoJDBC {
    public Book findBookById (Integer bookId) {
        try (Connection connection = DBConnection.INSTANCE.getConnection()) {
            if (connection != null) {
                System.out.println("Ура! Мы подключились к базе данных.");
            } else {
                System.out.println("БД недоступна");
            }


            String select = "select * from book where id = ?";
            PreparedStatement selectQuery = connection.prepareStatement(select);
            selectQuery.setInt(1, bookId);
            ResultSet resultSet = selectQuery.executeQuery();

//            Создание и вывод объекта
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setAuthor(resultSet.getString("author"));
                book.setTitle(resultSet.getString("title"));
                book.setDataAdded(resultSet.getDate("date_added"));
                System.out.println(book);
            }
        } catch (SQLException ex) {
            System.out.println("Error" + ex.getMessage());
        }
        return null;
    }
}