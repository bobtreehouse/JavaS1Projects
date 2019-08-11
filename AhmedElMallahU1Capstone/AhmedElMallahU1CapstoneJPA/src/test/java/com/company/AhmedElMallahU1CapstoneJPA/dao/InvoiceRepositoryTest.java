package com.company.AhmedElMallahU1CapstoneJPA.dao;

import com.company.AhmedElMallahU1CapstoneJPA.dto.Invoice;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceRepositoryTest {
    @Autowired
    InvoiceRepository invoiceRepository;

    @Before
    public void setUp() throws Exception {
        invoiceRepository.deleteAll();
    }

    @Test
    public void addGetDeleteAndGetAllInvoice() {

        //Adding Invoice
        Invoice invoice = new Invoice();
        invoice.setName("Ahmed ElMallah");
        invoice.setStreet("18Th Street");
        invoice.setCity("Bayonne");
        invoice.setState("NJ");
        invoice.setZipcode("07002");
        invoice.setItemType("T-Shirts");
        invoice.setItemId(1);
        invoice.setQuantity(5);
        //Properties Setup by Service Layer - hard coded for now
        invoice.setUnitPrice(new BigDecimal("300.5").setScale(2));
        invoice.setProcessingFee(new BigDecimal("14.99").setScale(2));
        invoice.setTax(new BigDecimal("0.05").setScale(2));
        invoice.setSubtotal(new BigDecimal("300.5").setScale(2));
        invoice.setTotal(new BigDecimal("350.25").setScale(2));

        //Add Dao
        Invoice addDaoInvoice = invoiceRepository.save(invoice);

        //Get Dao
        Invoice getDaoInvoice = invoiceRepository.findById(addDaoInvoice.getId()).get();

        assertEquals(addDaoInvoice, getDaoInvoice);

        //Adding another Invoice
        Invoice invoice2 = new Invoice();
        invoice2.setName("Sal Hobbi");
        invoice2.setStreet("161 Newkirk");
        invoice2.setCity("Jersey City");
        invoice2.setState("NJ");
        invoice2.setZipcode("07101");
        invoice2.setItemType("Games");
        invoice2.setItemId(1);
        invoice2.setQuantity(5);
        //Properties Setup by Service Layer - hard coded for now
        invoice2.setUnitPrice(new BigDecimal("300.5").setScale(2));
        invoice2.setProcessingFee(new BigDecimal("14.99").setScale(2));
        invoice2.setTax(new BigDecimal("0.05").setScale(2));
        invoice2.setSubtotal(new BigDecimal("300.5").setScale(2));
        invoice2.setTotal(new BigDecimal("350.25").setScale(2));

        invoice2 = invoiceRepository.save(invoice2);

        //GetAll Dao
        List<Invoice> invoiceList = invoiceRepository.findAll();

        assertEquals(invoiceList.size(),2);

        //Delete Dao
        invoiceRepository.deleteById(invoice2.getId());

        try {
            invoice = invoiceRepository.findById(invoice2.getId()).get();
        } catch (NoSuchElementException e){
            invoice = null;
        }


        assertNull(invoice);
    }
}