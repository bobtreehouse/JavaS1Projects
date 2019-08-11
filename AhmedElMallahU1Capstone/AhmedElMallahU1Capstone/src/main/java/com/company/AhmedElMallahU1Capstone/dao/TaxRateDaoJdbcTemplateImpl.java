package com.company.AhmedElMallahU1Capstone.dao;

import com.company.AhmedElMallahU1Capstone.dto.TaxRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class TaxRateDaoJdbcTemplateImpl implements TaxRateDao {

    //
    // Constructor
    //
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TaxRateDaoJdbcTemplateImpl(JdbcTemplate newJdbcTemplate){
        this.jdbcTemplate = newJdbcTemplate;
    }

    //
    // Mapper
    //
    private TaxRate mapRowToTaxRate(ResultSet rs, int rowNum) throws SQLException {
        TaxRate taxRate = new TaxRate();
        taxRate.setState(rs.getString("state"));
        taxRate.setRate(rs.getBigDecimal("rate"));

        return taxRate;
    }

    //
    // Prepared statement strings
    //
   private static final String SELECT_TAX_RATE_BY_STATE_SQL =
            "select * from sales_tax_rate where state = ?";

    //
    // Implementations
    //
    @Override
    public TaxRate getByState(String state) {
        return jdbcTemplate.queryForObject(SELECT_TAX_RATE_BY_STATE_SQL, this::mapRowToTaxRate, state);
    }
}
