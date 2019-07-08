package com.RentalStore.RentalStore.dao;
import com.RentalStore.RentalStore.dao.CustomerInvoiceDao;
import com.RentalStore.RentalStore.model.Invoice;
import com.RentalStore.RentalStore.model.Customer;
import com.RentalStore.RentalStore.model.InvoiceItem;
import com.RentalStore.RentalStore.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//step 1
@Repository
public class CustomerInvoiceJdbcTemplateImpl implements CustomerInvoiceDao {

    private JdbcTemplate jdbcTemplate;


    @Autowired
    public CustomerInvoiceJdbcTemplateImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    // start part 2{
// start part 2
// Prepared statement strings
    private static final String INSERT_CAR_SQL =
            "insert into rental_store (customer_id, first_name, last_name, email, company, phone) " +
                    "values (?, ?, ?, ?, ?, ?)";

    private static final String SELECT_CUSTOMER_SQL =
            "select * from rental_inventory where id = ?";

    private static final String SELECT_ALL_CUSTOMER_SQL =
            "select * from rental_inventory";

    private static final String DELETE_CUSTOMER_SQL =
            "delete from rental_inventory where id = ?";

    private static final String UPDATE_CUSTOMER_SQL =
            "update rental_inventory set Id = ?, artist_id = ?, release_date = ?, label_id = ?, list_price = ? where id = ?";
//part of 2 cont'd

    private Customer mapRowToCar(ResultSet rs, int rowNum) throws SQLException {//ResultSet is the whole row
        Customer customer = new Customer();
        customer.setId(rs.getInt("customer_id"));
        customer.setFirst_name(rs.getString("first_name"));
        customer.setLast_name(rs.getString("last_name"));
        customer.setEmail(rs.getString("email"));
        customer.setPhone(rs.getString("phone"));

        return customer;
    }
    // part 3  & change body code

    @Transactional
    @Override
    public Customer addCustomer (Customer customer) {

        jdbcTemplate.update(INSERT_CAR_SQL,
                customer.getId(),
                customer.getFirst_name(),
                customer.getLast_name(),
                customer.getEmail(),
                customer.getPhone());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
        Customer.setId(id);
        return customer;
    }

    @Override
    public Customer getCustomer (int id) {

        try {
            return jdbcTemplate.queryForObject(SELECT_CUSTOMER_SQL, this::mapRowToCustomer, id);
        } catch (EmptyResultDataAccessException e ) {
            return null;
        }
    }


    @Override
    public List<Customer> getAllCustomers() {
        return jdbcTemplate.query(SELECT_ALL_CUSTOMER_SQL, this::mapRowTocustomer_id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        jdbcTemplate.update(UPDATE_CUSTOMER_SQL, customer),
                        customer.setId(),
                        customer.setFirst_name(),
                        customer.setLast_name(),
                        customer.setEmail(),
                        customer.setCompany(),
                        customer.setPhone();

    }

    @Override
    public void deleteCustomer(int id) {
        jdbcTemplate.update(DELETE_CUSTOMER_SQL,id);

    }
}


