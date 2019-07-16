package BobTriesteU1Capstone.GameStore.dao;
import BobTriesteU1Capstone.GameStore.model.ProcessingFee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProcessingFeeJdbcTemplateImpl implements ProcessingFeeDao {

    private JdbcTemplate jdbcTemplate;


    private static final String GET_PROCESSINGFEE_SQL =
            "select * from processing_fee where product_type = ?";



    private static final String SELECT_ALL_PROCESSINGFEES_SQL =
            "select * from processing_fee";



    @Autowired
    public ProcessingFeeJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    @Override
    @Transactional
    public ProcessingFee getProcessingFee(int id) {
        try {
            return jdbcTemplate.queryForObject(GET_PROCESSINGFEE_SQL, this::mapRowToProcessingFee , id);
        } catch (EmptyResultDataAccessException e) {
            // if there is no match for this console return null
            return null;
        }
    }


    @Override
    public List<ProcessingFee> getAllProcessingFees() {

        return jdbcTemplate.query(SELECT_ALL_PROCESSINGFEES_SQL, this::mapRowToProcessingFee );
    }




    private ProcessingFee mapRowToProcessingFee (ResultSet rs, int rowNum) throws SQLException {
        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setProductType(rs.getString("product_type"));
        processingFee.setFee(rs.getBigDecimal("fee"));


        return processingFee;
    }
}
