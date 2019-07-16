//package BobTriesteU1Capstone.GameStore.dao;
//
//import BobTriesteU1Capstone.GameStore.model.*;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
//import static org.junit.Assert.*;
//
//public class SalesTaxRateJdbcTemplateImplTest {
//
//
//    @Autowired
//    ConsoleDao consoleDao;
//    @Autowired
//    GameDao gameDao;
//    @Autowired
//    InvoiceDao invoiceDao;
//    @Autowired
//    ProcessingFeeDao processingFeeDao;
//    @Autowired
//    SalesTaxRateDao salesTaxRateDao;
//    @Autowired
//    TshirtDao tshirtDao;
//
//
//    @Before
//    public void setUp() throws Exception {
//        List<Console> consoles = consoleDao.getAllConsoles();
//        for (Console cons : consoles) {
//            consoleDao.deleteConsole(cons.getGameId());
//        }
//
//        List<Game> games = gameDao.getAllGames();
//        for (Game g : games) {
//            invoiceDao.deleteInvoice(g.getGameId());
//        }
//
//        List<Invoice> invoices1 = invoiceDao.getAllInvoices();
//        for (Invoice i : invoices1) {
//            invoiceDao.deleteInvoice(i.getInvoiceId());
//        }
//
//
//        List<Tshirt> tshirts = tshirtDao.getAllTshirts();
//        for (Tshirt tee : tshirts) {
//            tshirtDao.deleteTshirt(tee.getTshirtId());
//        }
//
//
//    }
//    @Test
//    public void getSalesTaxRate() {
//    }
//
//    @Test
//    public void getAllSalesTaxRates() {
//    }
//
//
//}