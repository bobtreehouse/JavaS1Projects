package BobTriesteU1Capstone.GameStore.dao;
import BobTriesteU1Capstone.GameStore.model.SalesTaxRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class SalesTaxRateJdbcTemplateImpl implements SalesTaxRateDao {

    private JdbcTemplate jdbcTemplate;

    private static final String GET_SALESTAXRATE_SQL =
           " select * from sales_tax_rate where state = ?";



    @Autowired
    public SalesTaxRateJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public SalesTaxRate getSalesTaxRate(String state) {
        return jdbcTemplate.queryForObject(GET_SALESTAXRATE_SQL, this::mapRowToSalesTaxRate, state);
    }



    private SalesTaxRate mapRowToSalesTaxRate(ResultSet rs, int rowNum) throws SQLException {
        SalesTaxRate salesTaxRate = new SalesTaxRate();
        salesTaxRate.setState(rs.getString("state"));
        salesTaxRate.setRate(rs.getBigDecimal("rate"));


        return salesTaxRate;
    }
}
