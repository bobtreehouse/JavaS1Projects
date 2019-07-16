package BobTriesteU1Capstone.GameStore.dao;
import BobTriesteU1Capstone.GameStore.model.Console;
import BobTriesteU1Capstone.GameStore.model.Game;
import BobTriesteU1Capstone.GameStore.model.Invoice;
import BobTriesteU1Capstone.GameStore.model.ProcessingFee;
import BobTriesteU1Capstone.GameStore.model.SalesTaxRate;
import BobTriesteU1Capstone.GameStore.model.Tshirt;

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
public class ConsoleJdbcTemplateImplTest {


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
    public void addGetDeleteConsole() {
        Console console = new Console();
        console.setModel("Xbox1");
        console.setManufacturer("MSFT");
        console.setProcessor("AMD Ryzen");
        console.setPrice(new BigDecimal(199.99).setScale(2));
        console.setQuantity(4);

        console = consoleDao.addConsole(console);

        Console console1 = consoleDao.getConsole(console.getGameId());
        assertEquals(console1, console);

        consoleDao.deleteConsole(console.getGameId());
        console1 = consoleDao.getConsole(console.getGameId());
        assertNull(console1);

    }



    @Test
    public void getAllConsoles() {

        Console console = new Console();
        console.setModel("Xbox1");
        console.setManufacturer("MSFT");
        console.setProcessor("AMD Ryzen");
        console.setPrice(new BigDecimal(199.99).setScale(2));
        console.setQuantity(4);
        console = consoleDao.addConsole(console);

        console = new Console();

        console.setModel("PS4");
        console.setManufacturer("Sony");
        console.setProcessor("NVDA 1080t");
        console.setPrice(new BigDecimal(189.98).setScale(2));
        console.setQuantity(2);
        console = consoleDao.addConsole(console);

        List<Console> consList = consoleDao.getAllConsoles();
        assertEquals(2, consList.size());
    }

    @Test
    public void updateConsole() {

        Console console = new Console();
        console.setModel("Xbox1");
        console.setManufacturer("MSFT");
        console.setProcessor("AMD Ryzen");
        console.setPrice(new BigDecimal(199.99).setScale(2));
        console.setQuantity(4);
        console = consoleDao.addConsole(console);

        console.setModel("Xbox1");
        console.setManufacturer("MSFT");
        console.setProcessor("NVDA 1070");
        console.setPrice(new BigDecimal(179.99).setScale(2));
        console.setQuantity(1);
        consoleDao.updateConsole(console);

        Console console1  = consoleDao.getConsole(console.getGameId());
        assertEquals(console1,console);
    }


}