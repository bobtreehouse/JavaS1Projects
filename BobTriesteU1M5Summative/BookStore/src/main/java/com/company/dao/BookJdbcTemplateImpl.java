package com.company.dao;

import com.company.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookJdbcTemplateImpl implements BookDao {


    // Prepared statement strings
    private static final String INSERT_BOOK_SQL =
            "insert into book (book_id, isbn, publish_date, author_id, title, publisher_id, price ) values (?, ?, ?, ?, ?, ?, ?)";

    private static final String SELECT_BOOK_SQL =
            "select * from book where book_id = ?";

    private static final String READ_BOOK_SQL =
            "select * from book where book_id = ?";

    private static final String SELECT_ALL_BOOKS_SQL =
            "select * from book";

    private static final String DELETE_BOOK_SQL =
            "delete from book where book_id = ?";

    private static final String UPDATE_BOOK_SQL =
            "update book set price = ?, isbn = ?, publish_date = ?, author_id = ?, title = ?, publisher_id = ? where book_id = ?";

    private static final String SELECT_BOOKS_BY_TITLE_SQL =
            "select * from book where title = ?";

    private static final String SELECT_BOOKS_BY_AUTHOR_SQL =
            "select * from book where author_id = ?";



    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BookJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Book getBook(int id) {

        try {

            return jdbcTemplate.queryForObject(SELECT_BOOK_SQL, this::mapRowToBook, id);

        } catch (EmptyResultDataAccessException e) {
            // if nothing is returned just catch the exception and return null
            return null;
        }

    }

    private <T> T mapRowToBook(ResultSet resultSet, int i) {
        return null;
    }


    @Override
    public List<Book> getAllBooks() {

        return jdbcTemplate.query(SELECT_ALL_BOOKS_SQL , this::mapRowToBook);
    }

    @Override
    public List<Book> getBooksByAuthor(int author_id) {

        return jdbcTemplate.query(SELECT_BOOKS_BY_AUTHOR_SQL, this::mapRowToBook, author_id);
    }

    @Override
    public List<Book> getBooksByTitle(String title) {

        return jdbcTemplate.query(SELECT_BOOKS_BY_TITLE_SQL, this::mapRowToBook, title);
    }

    @Override
    @Transactional
    public Book addBook(Book book) {

        jdbcTemplate.update(INSERT_BOOK_SQL,
                book.getBook_id(),
                book.getIsbn(),
                book.getPublish_date(),
                book.getAuthor_id(),
                book.getTitle(),
                book.getPublisher_id());
                book.getPrice();

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        book.setBook_id(id);

        return book;
    }

    @Override
    public void updateBook(Book book) {

        jdbcTemplate.update(UPDATE_BOOK_SQL,
                book.getBook_id(),
                book.getIsbn(),
                book.getPublish_date(),
                book.getAuthor_id(),
                book.getTitle(),
                book.getPublisher_id(),
                book.getPrice());
    }

    @Override
    public void deleteBook(int id) {

        jdbcTemplate.update(DELETE_BOOK_SQL, id);
    }

    @Override
    public void readBook(int id) {

        jdbcTemplate.update(READ_BOOK_SQL, id);
    }

    // Helper methods
    private Book mapRowToCoffee(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.getBook_id(rs.getInt("book_id"));
        book.getIsbn(rs.getInt("isbn"));
        book.getPublish_date(rs.getDate("publish_date"));
        book.getAuthor_id(rs.getInt("author_id"));
        book.getTitle(rs.getString("title"));
        book.setPublisher_id(rs.getInt("publisher_id"));
        book.setPrice(rs.getDouble("price"));

        return book;
    }

}
