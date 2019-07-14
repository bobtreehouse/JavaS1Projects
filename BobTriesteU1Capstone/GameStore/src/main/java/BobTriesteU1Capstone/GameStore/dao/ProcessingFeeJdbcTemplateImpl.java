package BobTriesteU1Capstone.GameStore.dao;
import BobTriesteU1Capstone.GameStore.model.ProcessingFee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

    private static final String UPDATE_PROCESSINGFEE_SQL =
            "update processing_fee set product_type = ?, fee = ? where product_type = ?";

    private static final String DELETE_PROCESSINGFEE_SQL =
            "delete from processing_fee where product_type = ?";

    @Autowired
    public ProcessingFeeJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    @Override
//    @Transactional
//    public ProcessingFee getProcessingFee(ProcessingFee processingFee) {
//        jdbcTemplate.update(GET_PROCESSINGFEE_SQL,
//
//                processingFee.getProductType(),
//                processingFee.getFee());
//
//        return processingFee;
//    }

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

    @Override
    public void updateProcessingFee (ProcessingFee  processingFee ) {
        jdbcTemplate.update(
                UPDATE_PROCESSINGFEE_SQL,
                processingFee.getProductType(),
                processingFee.getFee());

    }

    @Override
    public void deleteProcessingFee(int processingFee) {
        jdbcTemplate.update(DELETE_PROCESSINGFEE_SQL);
    }

    private ProcessingFee mapRowToProcessingFee (ResultSet rs, int rowNum) throws SQLException {
        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setProductType(rs.getString("product_type"));
        processingFee.setFee(rs.getBigDecimal("fee"));


        return processingFee;
    }
}
