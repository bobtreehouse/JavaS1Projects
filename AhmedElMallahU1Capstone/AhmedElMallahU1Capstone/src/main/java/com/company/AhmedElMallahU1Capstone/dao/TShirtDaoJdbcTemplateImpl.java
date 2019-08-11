package com.company.AhmedElMallahU1Capstone.dao;

import com.company.AhmedElMallahU1Capstone.dto.Game;
import com.company.AhmedElMallahU1Capstone.dto.TShirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TShirtDaoJdbcTemplateImpl implements TShirtDao {

    //
    // Constructor
    //
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TShirtDaoJdbcTemplateImpl(JdbcTemplate newJdbcTemplate){
        this.jdbcTemplate = newJdbcTemplate;
    }

    //
    // Mapper
    //
    private TShirt mapRowToTShirt(ResultSet rs, int rowNum) throws SQLException {
        TShirt tShirt = new TShirt();
        tShirt.setId(rs.getInt("t_shirt_id"));
        tShirt.setSize(rs.getString("size"));
        tShirt.setColor(rs.getString("color"));
        tShirt.setDescription(rs.getString("description"));
        tShirt.setPrice(rs.getBigDecimal("price"));
        tShirt.setQuantity(rs.getInt("quantity"));

        return tShirt;
    }

    //
    // Prepared statement strings
    //
    private static final String INSERT_T_SHIRT_SQL =
            "insert into t_shirt (size, color, description, price, quantity) values (?, ?, ?, ?, ?)";

    private static final String SELECT_T_SHIRT_SQL =
            "select * from t_shirt where t_shirt_id = ?";

    private static final String SELECT_ALL_T_SHIRTS_SQL =
            "select * from t_shirt";

    private static final String DELETE_T_SHIRT_SQL =
            "delete from t_shirt where t_shirt_id = ?";

    private static final String UPDATE_T_SHIRT_SQL =
            "update t_shirt set size = ?, color = ?, description = ?, price = ?, quantity = ? where t_shirt_id = ?";

    private static final String SELECT_T_SHIRTS_BY_SIZE_SQL =
            "select * from t_shirt where size = ?";

    private static final String SELECT_T_SHIRTS_BY_COLOR_SQL =
            "select * from t_shirt where color = ?";

    //
    // Implementations
    //
    @Override
    @Transactional
    public TShirt addTShirt(TShirt tShirt) {
        jdbcTemplate.update(INSERT_T_SHIRT_SQL,
                tShirt.getSize(), tShirt.getColor(), tShirt.getDescription(), tShirt.getPrice(), tShirt.getQuantity());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        tShirt.setId(id);

        return tShirt;
    }

    @Override
    public TShirt getTShirt(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_T_SHIRT_SQL, this::mapRowToTShirt, id);
        } catch (EmptyResultDataAccessException e) {
            throw new NullPointerException("T-shirt id doesn't exist.");
        }
    }

    @Override
    public List<TShirt> getAllTShirts() {
        return jdbcTemplate.query(SELECT_ALL_T_SHIRTS_SQL, this::mapRowToTShirt);
    }

    @Override
    @Transactional
    public TShirt updateTShirt(TShirt tShirt) {
        jdbcTemplate.update(UPDATE_T_SHIRT_SQL,
                tShirt.getSize(), tShirt.getColor(), tShirt.getDescription(), tShirt.getPrice(), tShirt.getQuantity(),
                tShirt.getId());

        try {
            return jdbcTemplate.queryForObject(SELECT_T_SHIRT_SQL, this::mapRowToTShirt, tShirt.getId());
        } catch (EmptyResultDataAccessException e) {
            throw new NullPointerException("T-shirt id doesn't exist.");
        }
    }

    @Override
    @Transactional
    public void deleteTShirt(int id) {
        try {
            jdbcTemplate.queryForObject(SELECT_T_SHIRT_SQL, this::mapRowToTShirt, id);
            jdbcTemplate.update(DELETE_T_SHIRT_SQL, id);
        } catch (EmptyResultDataAccessException e) {
            throw new NullPointerException("T-shirt id doesn't exist.");
        }
    }

    @Override
    public List<TShirt> getTShirtByColor(String color) {
        return jdbcTemplate.query(SELECT_T_SHIRTS_BY_COLOR_SQL, this::mapRowToTShirt, color);
    }

    @Override
    public List<TShirt> getTShirtBySize(String size) {
        return jdbcTemplate.query(SELECT_T_SHIRTS_BY_SIZE_SQL, this::mapRowToTShirt, size);
    }
}
