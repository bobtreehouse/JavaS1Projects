package BobTriesteU1Capstone.GameStore.dao;
import BobTriesteU1Capstone.GameStore.controller.InvoiceInventoryController;
import BobTriesteU1Capstone.GameStore.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class InvoiceJdbcTemplateImpl implements InvoiceDao {

    private JdbcTemplate jdbcTemplate;

    private static final String ADD_INVOICE_SQL =
            "insert into invoice (name, street, city, state, zipcode, item_type, item_id, unit_price, quantity, subtotal, tax, processing_fee, total) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String GET_INVOICE_SQL =
            "select * from invoice where invoice_id = ?";

    private static final String SELECT_ALL_INVOICES_SQL =
            "select * from invoice";

    private static final String UPDATE_INVOICE_SQL =
            "update invoice set name = ?, street = ?, city = ?, state = ?, zipcode = ?, item_type=?, item_id=?, unti_price=?, quantity=?, subtotal=?, tax=?, processing_fee=?, total=? where invoice_id = ?";

    private static final String DELETE_INVOICE_SQL=
            "delete from invoice where invoice_id = ?";

    private static final String GET_INVOICE_BY_CONSOLE_SQL=
            "select * from invoice where console_id = ?";

    @Autowired
    public InvoiceJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Invoice addInvoice(Invoice invoice) {
        jdbcTemplate.update(ADD_INVOICE_SQL,

                invoice.getName(),
                invoice.getStreet(),
                invoice.getCity(),
                invoice.getState(),
                invoice.getZipcode(),
                invoice.getItemType(),
                invoice.getItemId(),
                invoice.getUnitPrice(),
                invoice.getQuantity(),
                invoice.getSubtotal(),
                invoice.getTax(),
                invoice.getProcessiongFee(),
                invoice.getTotal());

        int invoice_id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

        invoice.setInvoiceId(invoice_id);

        return invoice;
    }

    @Override
    public Invoice getInvoice(int id) {
        try {
            return jdbcTemplate.queryForObject(GET_INVOICE_SQL, this::mapRowToInvoice, id);
        } catch (EmptyResultDataAccessException e) {
            // if there is no match for this console return null
            return null;
        }
    }


    @Override
    public List<Invoice> getAllInvoices() {

        return jdbcTemplate.query(SELECT_ALL_INVOICES_SQL, this::mapRowToInvoice);
    }

    @Override
    public List<Invoice> getInvoicesByConsoleId() {

        return jdbcTemplate.query(GET_INVOICE_BY_CONSOLE_SQL, this::mapRowToInvoice);
    }

    @Override
    public void updateInvoice (Invoice invoice) {
        jdbcTemplate.update(
                UPDATE_INVOICE_SQL,
                invoice.getName(),
                invoice.getStreet(),
                invoice.getCity(),
                invoice.getState(),
                invoice.getZipcode(),
                invoice.getItemType(),
                invoice.getItemId(),
                invoice.getUnitPrice(),
                invoice.getQuantity(),
                invoice.getSubtotal(),
                invoice.getTax(),
                invoice.getProcessiongFee(),
                invoice.getTotal());

    }

    @Override
    public void deleteInvoice(int id) {
        jdbcTemplate.update(DELETE_INVOICE_SQL, id);
}

    private Invoice mapRowToInvoice(ResultSet rs, int rowNum) throws SQLException {
        Invoice invoice = new Invoice();
        invoice.setInvoiceId(rs.getInt("invoice_id"));
        invoice.setName(rs.getString("name"));
        invoice.setStreet(rs.getString("street"));
        invoice.setCity(rs.getString("city"));
        invoice.setState(rs.getString("state"));
        invoice.setZipcode(rs.getString("zipcode"));
        invoice.setItemType(rs.getString("item_type"));
        invoice.setItemId(rs.getInt("item_id"));
        invoice.setUnitPrice(rs.getBigDecimal("unit_price"));
        invoice.setQuantity(rs.getInt("quantity"));
        invoice.setSubtotal(rs.getBigDecimal("subtotal"));
        invoice.setTax(rs.getBigDecimal("tax"));
        invoice.setProcessiongFee(rs.getBigDecimal("processing_fee"));
        invoice.setTotal(rs.getBigDecimal("total"));



        return invoice;
    }
}
