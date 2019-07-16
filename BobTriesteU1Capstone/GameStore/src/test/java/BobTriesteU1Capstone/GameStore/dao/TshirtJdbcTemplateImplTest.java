package BobTriesteU1Capstone.GameStore.dao;

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
public class TshirtJdbcTemplateImplTest {


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
    public void addGetDeleteTshirt() {
        Tshirt  tshirt = new Tshirt();
        tshirt.setSize("L");
        tshirt.setColor("Black");
        tshirt.setDescription("SonyGamer");
        tshirt.setPrice(new BigDecimal(9.95).setScale(2));
        tshirt.setQuantity(9);

        tshirt = tshirtDao.addTshirt((tshirt));

        Tshirt tshirt1 = tshirtDao.getTshirt(tshirt.getTshirtId());
        assertEquals(tshirt1, tshirt);

        tshirtDao.deleteTshirt(tshirt.getTshirtId());
        tshirt1 = tshirtDao.getTshirt((tshirt.getTshirtId()));
        assertNull(tshirt1);

    }


    @Test
    public void getAllTshirts() {

        Tshirt  tshirt = new Tshirt();
        tshirt.setSize("L");
        tshirt.setColor("Black");
        tshirt.setDescription("SonyGamer");
        tshirt.setPrice(new BigDecimal(9.95).setScale(2));
        tshirt.setQuantity(9);

        tshirt = tshirtDao.addTshirt((tshirt));

        tshirt = new Tshirt();
        tshirt.setSize("YM");
        tshirt.setColor("Blue");
        tshirt.setDescription("Xbox Live");
        tshirt.setPrice(new BigDecimal("12.95"));
        tshirt.setQuantity(13);

        List<Tshirt> teeList = tshirtDao.getAllTshirts();
        assertEquals(2, teeList.size());
    }

    @Test
    public void updateTshirt() {

        Tshirt  tshirt = new Tshirt();
        tshirt.setSize("L");
        tshirt.setColor("Black");
        tshirt.setDescription("SonyGamer");
        tshirt.setPrice(new BigDecimal("9.95"));
        tshirt.setQuantity(9);

        tshirt = tshirtDao.addTshirt((tshirt));

        tshirt.setPrice(new BigDecimal("6.95"));
        tshirt.setQuantity(7);

        Tshirt tshirt1 = tshirtDao.getTshirt((tshirt.getTshirtId()));
        assertEquals(tshirt1, tshirt);
    }


}