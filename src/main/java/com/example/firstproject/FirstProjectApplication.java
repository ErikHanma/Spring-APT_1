package com.example.firstproject;

import com.example.firstproject.bbexample.dao.BookDAOBean;
import com.example.firstproject.bbexample.dao.BookDaoJDBC;
import com.example.firstproject.bbexample.db.DBConnection;
import com.example.firstproject.bbexample.model.Book;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

//урааа
@SpringBootApplication
public class FirstProjectApplication implements CommandLineRunner {
    private BookDAOBean bookDAOBean;

    public FirstProjectApplication(BookDAOBean bookDAOBean) {
        this.bookDAOBean = bookDAOBean;
    }

    @Autowired
    public void setBookDAOBean(BookDAOBean bookDAOBean) {
        this.bookDAOBean = bookDAOBean;
    }

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(FirstProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//      bookDAOBean.findBookById(3);
        List<Book> bookList = jdbcTemplate.query("select * from books",
                ((rs, rowNum) -> Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getDate("date_added")
                )));
        bookList.forEach(System.out::println);
    }


}
