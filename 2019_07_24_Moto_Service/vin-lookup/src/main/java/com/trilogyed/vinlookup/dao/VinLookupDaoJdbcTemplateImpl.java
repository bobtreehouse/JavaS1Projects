package com.trilogyed.vinlookup.dao;

import com.trilogyed.vinlookup.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class VinLookupDaoJdbcTemplateImpl  implements  VinLookupDao{


    private static final String SELECT_VEHICLE_BY_VIN =
            "select * from vehicle where vin = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public VinLookupDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Vehicle getVehicleByVin (String vin) {
        try {
            return jdbcTemplate.queryForObject(SELECT_VEHICLE_BY_VIN, this::mapRowToVehicle, vin);
        } catch (EmptyResultDataAccessException e) {
            // if there is no match for this album id, return null
            return null;
        }
    }

    private Vehicle mapRowToVehicle(ResultSet rs, int rowNum) throws SQLException {
        Vehicle vehicle = new Vehicle();
        vehicle.setType(rs.getString("vehicle_type"));
        vehicle.setMake(rs.getString("make"));
        vehicle.setModel(rs.getString("model"));
        vehicle.setYear(rs.getString("year"));
        vehicle.setColor(rs.getString("color"));



        return vehicle;
    }
}