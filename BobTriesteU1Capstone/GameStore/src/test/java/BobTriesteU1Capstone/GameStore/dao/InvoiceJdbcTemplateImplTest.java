package BobTriesteU1Capstone.GameStore.dao;

import BobTriesteU1Capstone.GameStore.model.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class InvoiceJdbcTemplateImplTest {


    @Autowired
    ConsoleDao consoleDao;
    @Autowired
    GameDao gameDao;
    @Autowired
    InvoiceDao invoiceDao;
    @Autowired
    ProcessingFeeDao processingFeeDao;
    @Autowired
    SalesTaxRateDao salesTaxRateDao;
    @Autowired
    TshirtDao tshirtDao;


    @Before
    public void setUp() throws Exception {
        List<Console> consoles = consoleDao.getAllConsoles();
        for (Console cons : consoles) {
            consoleDao.deleteConsole(cons.getGameId());
        }

        List<Game> games = gameDao.getAllGames();
        for (Game g : games) {
            invoiceDao.deleteInvoice(g.getGameId());
        }

        List<Invoice> invoices1 = invoiceDao.getAllInvoices();
        for (Invoice i : invoices1) {
            invoiceDao.deleteInvoice(i.getInvoiceId());
        }


        List<Tshirt> tshirts = tshirtDao.getAllTshirts();
        for (Tshirt tee : tshirts) {
            tshirtDao.deleteTshirt(tee.getTshirtId());
        }


    }
    @Test
    public void addGetDeleteInvoice() {
        Invoice invoice = new Invoice();
        invoice.setName("Bob Tree");
        invoice.setStreet("10 Highview Ave");
        invoice.setCity("New Milford");
        invoice.setState("NJ");
        invoice.setZipcode("07607");
        invoice.setItemType("Tshirt");
        invoice.setItemId(909);
        invoice.setUnitPrice(new BigDecimal(12.99).setScale(2));
        invoice.setQuantity(2);
        invoice.setSubtotal(new BigDecimal(25.98).setScale(2));
        invoice.setTax(new BigDecimal(2.98).setScale(2));
        invoice.setProcessiongFee(new BigDecimal(1.98).setScale(2));
        invoice.setTotal(new BigDecimal(30.94).setScale(2));




    }

    @Test
    public void getInvoice() {
    }

    @Test
    public void getAllInvoices() {
    }

    @Test
    public void updateInvoice() {
    }

    @Test
    public void deleteInvoice() {
    }
}