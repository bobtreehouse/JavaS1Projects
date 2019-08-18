package BobTriesteU1Capstone.GameStore.dao;

import BobTriesteU1Capstone.GameStore.model.ProcessingFee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
@Repository
public class ProcessingFeeJdbcTemplateImpl implements ProcessingFeeDao{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProcessingFeeJdbcTemplateImpl(JdbcTemplate newJdbcTemplate){
        this.jdbcTemplate = newJdbcTemplate;
    }


    private static final String SELECT_PROCESSING_FEE_BY_PRODUCT_TYPE_SQL =
            "select * from processing_fee where product_type = ?";


    @Override
    public ProcessingFee getByItemType(String itemType) {
        return jdbcTemplate.queryForObject(SELECT_PROCESSING_FEE_BY_PRODUCT_TYPE_SQL, this::mapRowToProcessingFee, itemType);
    }



    private ProcessingFee mapRowToProcessingFee (ResultSet rs, int rowNum) throws SQLException {
        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setProductType(rs.getString("product_type"));
        processingFee.setFee(rs.getBigDecimal("fee"));


        return processingFee;
    }
}
