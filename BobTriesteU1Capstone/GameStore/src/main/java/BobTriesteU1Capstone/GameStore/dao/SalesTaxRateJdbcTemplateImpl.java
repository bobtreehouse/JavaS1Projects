package BobTriesteU1Capstone.GameStore.dao;
import BobTriesteU1Capstone.GameStore.model.SalesTaxRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SalesTaxRateJdbcTemplateImpl implements SalesTaxRateDao {

    private JdbcTemplate jdbcTemplate;



    private static final String GET_SALESTAXRATE_SQL =
            "select * from sales_tax_rate where state = ?";

    private static final String SELECT_ALL_SALESTAXRATES_SQL =
            "select * from sales_tax_rate";

    private static final String UPDATE_SALESTAXRATE_SQL =
            "update sales_tax_rate set state = ?, rate = ? where state = ?";

    private static final String DELETE_SALESTAXRATE =
            "delete from sales_tax_rate where state = ?";

    @Autowired
    public SalesTaxRateJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    @Transactional
    public SalesTaxRate getSalesTaxRate(int id) {
        try {
            return jdbcTemplate.queryForObject(GET_SALESTAXRATE_SQL, this::mapRowToSalesTaxRate, id);
        } catch (EmptyResultDataAccessException e) {
            // if there is no match for this console return null
            return null;
        }
    }


    @Override
    public List<SalesTaxRate> getAllSalesTaxRates() {

        return jdbcTemplate.query(SELECT_ALL_SALESTAXRATES_SQL, this::mapRowToSalesTaxRate);
    }

    @Override
    public void updateSalesTaxRate (SalesTaxRate salesTaxRate) {
        jdbcTemplate.update(
                UPDATE_SALESTAXRATE_SQL,
                salesTaxRate.getState(),
                salesTaxRate.getRate());


    }

    @Override
    public void deleteSalesTaxRate(int gameid) {
        jdbcTemplate.update(DELETE_SALESTAXRATE, gameid);
    }

    private SalesTaxRate mapRowToSalesTaxRate(ResultSet rs, int rowNum) throws SQLException {
        SalesTaxRate salesTaxRate = new SalesTaxRate();
        salesTaxRate.setState(rs.getString("state"));
        salesTaxRate.setRate(rs.getBigDecimal("rate"));


        return salesTaxRate;
    }
}
