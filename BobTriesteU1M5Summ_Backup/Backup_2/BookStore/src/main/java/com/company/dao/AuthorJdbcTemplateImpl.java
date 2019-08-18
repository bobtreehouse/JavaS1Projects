package com.company.dao;

import com.company.model.Author;
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
public class AuthorJdbcTemplateImpl implements AuthorDao {

    // Prepared statement strings
    private static final String INSERT_AUTHOR_SQL =
            "insert into author (author_id, first_name, last_name, street, city, state, postal_code, phone, email ) values (?, ?, ?, ?, ?, ?, ?)";

    private static final String SELECT_AUTHOR_SQL =
            "select * from author where author_id = ?";

    private static final String READ_AUTHOR_SQL =
            "select * from author where author_id = ?";

    private static final String SELECT_ALL_AUTHOR_SQL =
            "select * from author";

    private static final String DELETE_AUTHOR_SQL =
            "delete from author where author_id = ?";

    private static final String UPDATE_AUTHOR_SQL =
            "update author set phone = ?, first_name = ?, last_name = ?, street = ?, city = ?, state = ?, postal_code = ?, email = ? where author_id = ?";

    private static final String SELECT_BOOKS_BY_AUTHOR_SQL =
            "select * from book_store where title = ?";


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AuthorJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Author getAuthor(int id) {

        try {

            return jdbcTemplate.queryForObject(SELECT_AUTHOR_SQL, this::mapRowToAuthor, id);

        } catch (EmptyResultDataAccessException e) {
            // if nothing is returned just catch the exception and return null
            return null;
        }

    }


    @Override
    public List<Author> getAllAuthors() {

        return jdbcTemplate.query(SELECT_ALL_AUTHOR_SQL, this::mapRowToAuthor);
    }


    @Override
    public void deleteAuthor ( int id){

        jdbcTemplate.update(DELETE_AUTHOR_SQL, id);
    }

    @Override
    @Transactional
    public Author addAuthor(Author author) {

        jdbcTemplate.update(INSERT_AUTHOR_SQL,
                author.getAuthor_id(),
                author.getFirst_name(),
                author.getLast_name(),
                author.getStreet(),
                author.getCity(),
                author.getState());
                author.getPostal_code();
                author.getPhone();
                author.getEmail();

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        author.setAuthor_id(id);

        return author;
    }

    @Override
    public void updateAuthor(Author author) {

        jdbcTemplate.update(UPDATE_AUTHOR_SQL,
                author.getAuthor_id(),
                author.getFirst_name(),
                author.getLast_name(),
                author.getStreet(),
                author.getCity(),
                author.getState());
                author.getPostal_code();
                author.getPhone();
                author.getEmail();


    }

        // Helper methods
        private Author mapRowToAuthor(ResultSet rs, int rowNum) throws SQLException {
            Author author = new Author();
            author.setAuthor_id(rs.getInt("author_id"));
            author.setFirst_name(rs.getString("first_name"));
            author.setLast_name(rs.getString("last_name"));
            author.setStreet(rs.getString("street"));
            author.setCity(rs.getString("city"));
            author.setState(rs.getString("state"));
            author.setPostal_code(rs.getString("postal_code"));
            author.setPhone(rs.getString("phone"));
            author.setEmail(rs.getString("email"));

            return author;
        }

    }