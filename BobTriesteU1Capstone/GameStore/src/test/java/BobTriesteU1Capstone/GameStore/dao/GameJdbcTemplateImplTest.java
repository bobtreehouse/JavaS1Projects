package BobTriesteU1Capstone.GameStore.dao;
import BobTriesteU1Capstone.GameStore.model.Console;
import BobTriesteU1Capstone.GameStore.model.Game;
import BobTriesteU1Capstone.GameStore.model.Invoice;
import BobTriesteU1Capstone.GameStore.model.ProcessingFee;
import BobTriesteU1Capstone.GameStore.model.SalesTaxRate;
import BobTriesteU1Capstone.GameStore.model.Tshirt;
import BobTriesteU1Capstone.GameStore.model.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;
import static org.junit.Assert.*;


public class GameJdbcTemplateImplTest {



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
        for (Game gams : games) {
            gameDao.deleteGame(gams.getGameId());
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
    public void addGetDeleteGame() {

        Game game = new Game();
        game.setTitle("Fortnite");
        game.setEsrb_rating("E");
        game.setDescription("Fun adventure");
        game.setPrice(new BigDecimal(21.99).setScale(2));
        game.setStudio("HongKongGames");
        game.setQuantity(50);
        game = gameDao.addGame(game);

        Game game1 = gameDao.getGame(game.getGameId());
        assertEquals(game1, game);

        gameDao.deleteGame(game.getGameId());

        game1 = gameDao.getGame(game.getGameId());
        assertNull(game1);



    }


    @Test
    public void getAllGames() {

        Game game = new Game();
        game.setTitle("Fortnite");
        game.setEsrb_rating("E");
        game.setDescription("Fun adventure");
        game.setPrice(new BigDecimal(21.99).setScale(2));
        game.setStudio("HongKongGames");
        game.setQuantity(50);
        game = gameDao.addGame(game);

        game = new Game();
        game.setTitle("RacerCars");
        game.setEsrb_rating("E");
        game.setDescription("Fun driving game");
        game.setPrice(new BigDecimal(11.99).setScale(2));
        game.setStudio("ElelctronicERTS");
        game.setQuantity(25);
        game = gameDao.addGame(game);

        List<Game> gamsList = gameDao.getAllGames();
        assertEquals(2, gamsList.size());

    }

    @Test
    public void updateGame() {


        Game game = new Game();
        game.setTitle("Fortnite");
        game.setEsrb_rating("E");
        game.setDescription("Fun adventure");
        game.setPrice(new BigDecimal(21.99).setScale(2));
        game.setStudio("HongKongGames");
        game.setQuantity(50);
        game = gameDao.addGame(game);

        game.setTitle("Fortnite");
        game.setEsrb_rating("E");
        game.setDescription("Fun adventure");
        game.setPrice(new BigDecimal(27.95).setScale(2));
        game.setStudio("HongKongGames");
        game.setQuantity(14);
        gameDao.updateGame(game);

        Game game1 = gameDao.getGame(game.getGameId());
        assertEquals(game1, game);

    }


}