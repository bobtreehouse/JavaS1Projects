package BobTriesteU1Capstone.GameStore.dao;
import BobTriesteU1Capstone.GameStore.model.Invoice;
import BobTriesteU1Capstone.GameStore.model.Console;
import BobTriesteU1Capstone.GameStore.model.Game;
import BobTriesteU1Capstone.GameStore.model.ProcessingFee;
import BobTriesteU1Capstone.GameStore.model.SalesTaxRate;

import BobTriesteU1Capstone.GameStore.model.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
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
            consoleDao.deleteConsole(cons.getConsoleId());
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
        invoice.setUnitPrice(new BigDecimal("12.99"));
        invoice.setQuantity(2);
        invoice.setSubtotal(new BigDecimal("25.98"));
        invoice.setTax(new BigDecimal("2.98"));
        invoice.setProcessiongFee(new BigDecimal("1.98"));
        invoice.setTotal(new BigDecimal("30.94"));

        invoice = invoiceDao.addInvoice(invoice);

        Invoice invoice0 = invoiceDao.getInvoice(invoice.getInvoiceId());
        //assertEquals(invoice0, invoice);

        invoiceDao.deleteInvoice(invoice.getInvoiceId());
        invoice0 = invoiceDao.getInvoice(invoice.getInvoiceId());
        assertNull(invoice0);

    }


    @Test
    public void getAllInvoices() {

        Invoice invoice = new Invoice();
        invoice.setName("Bob Tree");
        invoice.setStreet("10 Highview Ave");
        invoice.setCity("New Milford");
        invoice.setState("NJ");
        invoice.setZipcode("07607");
        invoice.setItemType("Tshirt");
        invoice.setItemId(909);
        invoice.setUnitPrice(new BigDecimal("12.99"));
        invoice.setQuantity(2);
        invoice.setSubtotal(new BigDecimal("25.98"));
        invoice.setTax(new BigDecimal("2.98"));
        invoice.setProcessiongFee(new BigDecimal("1.98"));
        invoice.setTotal(new BigDecimal("30.94"));
        invoice = invoiceDao.addInvoice(invoice);

        invoice = new Invoice();
        invoice.setName("Steph Tree");
        invoice.setStreet("15 Prospect Ave");
        invoice.setCity("Teaneck");
        invoice.setState("NJ");
        invoice.setZipcode("07607");
        invoice.setItemType("Game");
        invoice.setItemId(912);
        invoice.setUnitPrice(new BigDecimal("11.99"));
        invoice.setQuantity(2);
        invoice.setSubtotal(new BigDecimal("25.98"));
        invoice.setTax(new BigDecimal("2.98"));
        invoice.setProcessiongFee(new BigDecimal("1.98"));
        invoice.setTotal(new BigDecimal("29.94"));
        invoice = invoiceDao.addInvoice(invoice);


        List<Invoice> invoices1 = invoiceDao.getAllInvoices();
        assertEquals(2, invoices1.size());
    }




}