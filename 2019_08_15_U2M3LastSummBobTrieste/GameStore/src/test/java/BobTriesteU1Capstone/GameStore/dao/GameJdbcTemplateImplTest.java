package BobTriesteU1Capstone.GameStore.dao;
import BobTriesteU1Capstone.GameStore.model.Console;
import BobTriesteU1Capstone.GameStore.model.Game;
import BobTriesteU1Capstone.GameStore.model.Invoice;

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
            consoleDao.deleteConsole(cons.getConsoleId());
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
        game.setPrice(new BigDecimal("21.99"));
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
        game.setPrice(new BigDecimal("21.99"));
        game.setStudio("HongKongGames");
        game.setQuantity(50);
        game = gameDao.addGame(game);

        game = new Game();
        game.setTitle("RacerCars");
        game.setEsrb_rating("E");
        game.setDescription("Fun driving game");
        game.setPrice(new BigDecimal("11.99"));
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
        game.setPrice(new BigDecimal("21.99"));
        game.setStudio("HongKongGames");
        game.setQuantity(50);
        game = gameDao.addGame(game);

        //Changing Rating
        game.setEsrb_rating("T");

        //UpdateDao
        Game updateDaoGame = gameDao.updateGame(game);

        assertEquals(game,updateDaoGame);
    }

    @Test
    public void getGamesByStudio() {
        Game game = new Game();

        game.setTitle("Madden2018");
        game.setEsrb_rating("E");
        game.setDescription("A dance rhythm game developed by Ubisoft");
        game.setPrice(new BigDecimal("19.99"));
        game.setStudio("EA");
        game.setQuantity(5);

        game = gameDao.addGame(game);


        Game game1 = new Game();
        game1.setTitle("Madden II");
        game1.setEsrb_rating("E");
        game1.setDescription("A dance rhythm game developed by Ubisoft");
        game1.setPrice(new BigDecimal("14.99"));
        game1.setStudio("EA");
        game1.setQuantity(3);

        gameDao.addGame(game1);

        List<Game> gameList = gameDao.getGamesByStudio(game.getStudio());
        assertEquals(2, gameList.size());
    }


    @Test
    public void getGameByESRBRating() {
        Game game = new Game();
        game.setTitle("Adventures Of Eric and Michael");
        game.setEsrb_rating("Mature");
        game.setDescription("Dumb adventures of Eric and Michael.");
        game.setPrice(new BigDecimal("30.00"));
        game.setStudio("Sega");
        game.setQuantity(44);

        game = gameDao.addGame(game);

        Game game1 = new Game();
        game.setTitle("Adventures of Perri");
        game.setEsrb_rating("Mature");
        game.setDescription("Lt. Love Adventures");
        game.setPrice(new BigDecimal("35.00"));
        game.setStudio("343 Industries");
        game.setQuantity(44);
        gameDao.updateGame(game);

        List<Game>gameList = gameDao.getGameByESRBRating(game.getEsrb_rating());
        assertEquals(1, gameList.size());
    }

    @Test
    public void getGameByTitle() {
        Game game = new Game();
        game.setTitle("Adventures Kwok Kwok");
        game.setEsrb_rating("E");
        game.setDescription("Adventures of Billy and Mandy is a role-playing-game.");
        game.setPrice(new BigDecimal("17.00"));
        game.setStudio("Razer");
        game.setQuantity(4);

        game = gameDao.addGame(game);

        Game game1 = new Game();
        game.setEsrb_rating("M");
        game.setDescription("Pluto Explorer");
        game.setPrice(new BigDecimal("36.00"));
        game.setStudio("Rakuten");
        game.setQuantity(5);
        gameDao.updateGame(game);

        List<Game>gameList = gameDao.getGamesByStudio(game.getStudio());
        assertEquals(1, gameList.size());
    }


}