//package BobTriesteU1Capstone.GameStore.dao;
//
//import BobTriesteU1Capstone.GameStore.model.*;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.math.BigDecimal;
//import java.util.List;
//
//import static org.junit.Assert.*;
//
//public class ProcessingFeeJdbcTemplateImplTest {
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
//
//    @Test
//    public void GetProcessingFee() {
//        ProcessingFee processingFee = new ProcessingFee();
//        processingFee.setProductType("tshirt_fee");
//        processingFee.setFee(new BigDecimal(1.99).setScale(2));
//        processingFee.setState("NJ");
//
//        processingFee = processingFeeDao.getProcessingFee();
//
//        ProcessingFee processingFee1 = processingFeeDao.getProcessingFee(int id);
//        assertEquals(processingFee1, processingFee);
//
//        processingFeeDao.getProcessingFee(processingFee.getFee());
//        processingFee1 = processingFeeDao.getProcessingFee(processingFee.getFee());
//        assertNull(processingFee1);
//    }
//
//    @Test
//    public void getAllProcessingFees() {
//    }
//
//    @Test
//    public void updateProcessingFee() {
//    }
//
//
//}