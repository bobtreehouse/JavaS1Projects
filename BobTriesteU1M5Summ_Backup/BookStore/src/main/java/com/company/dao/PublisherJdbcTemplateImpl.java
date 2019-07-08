package com.company.dao;

import com.company.model.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PublisherJdbcTemplateImpl implements PublisherDao {

    // Prepared statement strings
    private static final String INSERT_PUBLISHER_SQL =
            "insert into publisher (publisher_id, name, street, city, state, postal_code, phone2, email2) values (?, ?, ?, ?, ?, ?)";

    private static final String SELECT_PUBLISHER_SQL =
            "select * from publisher where publisher_id = ?";

    private static final String SELECT_ALL_PUBLISHERS_SQL =
            "select * from publisher";

    private static final String DELETE_PUBLISHER_SQL =
            "delete from publisher where publisher_id = ?";

    private static final String UPDATE_PUBLISHER_SQL =
            "update publisher set publisher_id = ?, name = ?, city = ?, state = ?, postal_code = ?, phone2 = ?, email2=? where publisher_id = ?";

    private static final String SELECT_BOOKS_BY_PUBLISHER_SQL =
            "select * from books where publisher_id = ?";


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PublisherJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Publisher getPublisher(int publisher_id) {

        try {

            return jdbcTemplate.queryForObject(SELECT_BOOKS_BY_PUBLISHER_SQL, this::mapRowToPublisher, publisher_id);

        } catch (EmptyResultDataAccessException e) {
            // if nothing is returned just catch the exception and return null

            return null;

        }

    }


    @Override
    public List<Publisher> getAllPublishers() {

        return jdbcTemplate.query(SELECT_ALL_PUBLISHERS_SQL, this::mapRowToPublisher);
    }


    @Override
    @Transactional
    public Publisher addPublisher(Publisher publisher) {

        jdbcTemplate.update(INSERT_PUBLISHER_SQL,
                publisher.getPublisher_id(),
                publisher.getName(),
                publisher.getStreet2(),
                publisher.getCity2(),
                publisher.getState2(),
                publisher.getPostal_code2());
        publisher.getPhone2();
        publisher.getEmail2();

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        publisher.setPublisher_id(id);

        return publisher;
    }

    @Override
    public void updatePublisher(Publisher publisher) {

        jdbcTemplate.update(UPDATE_PUBLISHER_SQL,
                publisher.getPublisher_id(),
                publisher.getName(),
                publisher.getStreet2(),
                publisher.getCity2(),
                publisher.getState2(),
                publisher.getPostal_code2());
                publisher.getPhone2();
                publisher.getEmail2();
    }

    @Override
    public void selectPublisher(int id) {

        jdbcTemplate.update(SELECT_PUBLISHER_SQL, id);

    }

    @Override
    public void deletePublisher(int id) {

        jdbcTemplate.update(DELETE_PUBLISHER_SQL, id);
    }


    // Helper methods
    private Publisher mapRowToPublisher(ResultSet rs, int rowNum) throws SQLException {

        Publisher publisher = new Publisher();

        publisher.setPublisher_id(rs.getInt("publisher_id"));
        publisher.getName(rs.getString("name"));
        publisher.getStreet2(rs.getString("street"));
        publisher.getCity2(rs.getString("city"));
        publisher.getState2(rs.getString("state"));
        publisher.getPostal_code2(rs.getString("postal_code"));
        publisher.getPhone2(rs.getString("phone"));
        publisher.getEmail2(rs.getString("email"));

        return publisher;
    }

}

