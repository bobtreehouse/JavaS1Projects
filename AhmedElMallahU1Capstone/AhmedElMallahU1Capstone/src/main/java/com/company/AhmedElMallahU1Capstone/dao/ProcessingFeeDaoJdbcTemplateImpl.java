package com.company.AhmedElMallahU1Capstone.dao;

import com.company.AhmedElMallahU1Capstone.dto.ProcessingFee;
import com.company.AhmedElMallahU1Capstone.dto.TaxRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class ProcessingFeeDaoJdbcTemplateImpl implements ProcessingFeeDao{
    //
    // Constructor
    //
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProcessingFeeDaoJdbcTemplateImpl(JdbcTemplate newJdbcTemplate){
        this.jdbcTemplate = newJdbcTemplate;
    }

    //
    // Mapper
    //
    private ProcessingFee mapRowToProcessingFee(ResultSet rs, int rowNum) throws SQLException {
        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setProductType(rs.getString("product_type"));
        processingFee.setFee(rs.getBigDecimal("fee"));

        return processingFee;
    }

    //
    // Prepared statement strings
    //
    private static final String SELECT_PROCESSING_FEE_BY_PRODUCT_TYPE_SQL =
            "select * from processing_fee where product_type = ?";

    //
    // Implementations
    //
    @Override
    public ProcessingFee getByItemType(String itemType) {
        return jdbcTemplate.queryForObject(SELECT_PROCESSING_FEE_BY_PRODUCT_TYPE_SQL, this::mapRowToProcessingFee, itemType);
    }
}
