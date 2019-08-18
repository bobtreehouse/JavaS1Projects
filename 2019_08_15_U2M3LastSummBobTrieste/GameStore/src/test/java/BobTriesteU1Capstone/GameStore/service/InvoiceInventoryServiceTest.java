package BobTriesteU1Capstone.GameStore.service;
import BobTriesteU1Capstone.GameStore.service.ConsoleService;
import BobTriesteU1Capstone.GameStore.service.GameService;
import BobTriesteU1Capstone.GameStore.service.InvoiceInventoryService;
import BobTriesteU1Capstone.GameStore.service.TshirtService;
import BobTriesteU1Capstone.GameStore.viewmodel.GameViewModel;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;



import BobTriesteU1Capstone.GameStore.dao.*;
import BobTriesteU1Capstone.GameStore.model.*;

import org.junit.Before;

public class InvoiceInventoryServiceTest {

    GameDao gameDao;
    TshirtDao tShirtDao;
    ConsoleDao consoleDao;
    ProcessingFeeDao processingFeeDao;
    SalesTaxRateDao salesTaxRateDao;
    InvoiceDao invoiceDao;

    InvoiceInventoryService invoiceService;
    ConsoleService consoleService;
    GameService gameService;
    TshirtDao tshirtDao;
    TshirtService tshirtService;


    @Before
    public void setUp() throws Exception {
        setUpConsoleDaoMock();
        setUpGameDaoMock();
        setUpInvoiceDaoMock();

        setUpTShirtDaoMock();


        invoiceService = new InvoiceInventoryService(consoleDao, gameDao, invoiceDao, processingFeeDao, salesTaxRateDao, tShirtDao);
    }

    private void setUpInvoiceDaoMock() {
        invoiceDao = mock(InvoiceJdbcTemplateImpl.class);

        //Request Invoice
        Invoice invoice0 = new Invoice();
        invoice0.setName("Greg Tree");
        invoice0.setStreet("Highview AVe");
        invoice0.setCity("Bergenfield");
        invoice0.setState("NJ");
        invoice0.setZipcode("07621");
        invoice0.setItemType("T-Shirts");
        invoice0.setItemId(31);
        invoice0.setQuantity(5);
        invoice0.setUnitPrice(new BigDecimal("29.99").setScale(2));
        invoice0.setProcessiongFee(new BigDecimal("1.98").setScale(2));
        invoice0.setTax(new BigDecimal("7.50").setScale(2));
        invoice0.setSubtotal(new BigDecimal("149.95").setScale(2));
        invoice0.setTotal(new BigDecimal("159.43").setScale(2));

        //Response Invoice
        Invoice invoice1 = new Invoice();
        invoice1.setName("Greg Tree");
        invoice1.setStreet("Highview AVe");
        invoice1.setCity("Bergenfield");
        invoice1.setState("NJ");
        invoice1.setZipcode("07621");
        invoice1.setItemType("T-Shirts");
        invoice1.setItemId(31);
        invoice1.setQuantity(5);
        invoice1.setUnitPrice(new BigDecimal("29.99").setScale(2));
        invoice1.setProcessiongFee(new BigDecimal("1.98").setScale(2));
        invoice1.setTax(new BigDecimal("7.50").setScale(2));
        invoice1.setSubtotal(new BigDecimal("149.95").setScale(2));
        invoice1.setTotal(new BigDecimal("159.43").setScale(2));
        invoice1.setInvoiceId(41);

        //Test Case 2
        //Request Invoice
        Invoice invoice10 = new Invoice();
        invoice10.setName("Greg Tree");
        invoice10.setStreet("Highview AVe");
        invoice10.setCity("Bergenfield");
        invoice10.setState("NJ");
        invoice10.setZipcode("07621");
        invoice10.setItemType("T-Shirts");
        invoice10.setItemId(31);
        invoice10.setQuantity(15);
        invoice10.setUnitPrice(new BigDecimal("29.99").setScale(2));
        invoice10.setProcessiongFee(new BigDecimal("17.47").setScale(2));
        invoice10.setTax(new BigDecimal("22.49").setScale(2));
        invoice10.setSubtotal(new BigDecimal("449.85").setScale(2));
        invoice10.setTotal(new BigDecimal("489.81").setScale(2));

        //Response Invoice
        Invoice invoice11 = new Invoice();
        invoice11.setName("Greg Tree");
        invoice11.setStreet("Highview AVe");
        invoice11.setCity("Bergenfield");
        invoice11.setState("NJ");
        invoice11.setZipcode("07621");
        invoice11.setItemType("T-Shirts");
        invoice11.setItemId(31);
        invoice11.setQuantity(15);
        invoice11.setUnitPrice(new BigDecimal("29.99").setScale(2));
        invoice11.setProcessiongFee(new BigDecimal("17.47").setScale(2));
        invoice11.setTax(new BigDecimal("22.49").setScale(2));
        invoice11.setSubtotal(new BigDecimal("449.85").setScale(2));
        invoice11.setTotal(new BigDecimal("489.81").setScale(2));
        invoice11.setInvoiceId(41);

        doReturn(invoice1).when(invoiceDao).addInvoice(invoice0);
        doReturn(invoice11).when(invoiceDao).addInvoice(invoice10);
    }

    private void setUpGameDaoMock() {
        gameDao = mock(GameJdbcTemplateImpl.class);

        //Response Game
        Game game0 = new Game();
        game0.setTitle("RaceCar");
        game0.setDescription("RaceCar Desc");
        game0.setStudio("Feral");
        game0.setEsrb_rating("M");
        game0.setPrice(new BigDecimal("59.99").setScale(2));
        game0.setQuantity(500);

        //Request Game
        Game game1 = new Game();
        game1.setGameId(11);
        game1.setTitle("RaceCar");
        game1.setDescription("RaceCar Desc");
        game1.setStudio("Feral");
        game1.setEsrb_rating("M");
        game1.setPrice(new BigDecimal("59.99").setScale(2));
        game1.setQuantity(500);

        //Updated Game
        Game game1Updated = new Game();
        game1Updated.setGameId(11);
        game1Updated.setTitle("RaceCar");
        game1Updated.setDescription("RaceCar Desc");
        game1Updated.setStudio("Feral");
        game1Updated.setEsrb_rating("M");
        game1Updated.setPrice(new BigDecimal("29.99").setScale(2));
        game1Updated.setQuantity(500);

        //Additional Games
        //Adding 2nd Game
        Game game2 = new Game();
        game2.setGameId(12);
        game2.setTitle("RaceCar 2");
        game2.setDescription("RaceCar 2 Desc");
        game2.setStudio("Feral");
        game2.setEsrb_rating("M");
        game2.setPrice(new BigDecimal("59.99").setScale(2));
        game2.setQuantity(500);

        //Adding 3rd Game
        Game game3 = new Game();
        game3.setGameId(13);
        game3.setTitle("RaceCar 3");
        game3.setDescription("RaceCar 3 Desc");
        game3.setStudio("Sony");
        game3.setEsrb_rating("M");
        game3.setPrice(new BigDecimal("59.99").setScale(2));
        game3.setQuantity(500);

        List<Game> games = new ArrayList<>();
        List<Game> gamesByStudio = new ArrayList<>();
        List<Game> gamesByERSB = new ArrayList<>();
        List<Game> gamesByTitle = new ArrayList<>();

        games.add(game1); games.add(game2); games.add(game3);
        gamesByStudio.add(game1); gamesByStudio.add(game2);
        gamesByERSB.add(game2);
        gamesByTitle.add(game3);

        doReturn(game1).when(gameDao).addGame(game0);
        doReturn(game1).when(gameDao).getGame(11);
        doReturn(game1Updated).when(gameDao).updateGame(game1Updated);
        doReturn(games).when(gameDao).getAllGames();
        doReturn(gamesByStudio).when(gameDao).getGamesByStudio("Feral");
        doReturn(gamesByERSB).when(gameDao).getGameByESRBRating("M");
        doReturn(gamesByTitle).when(gameDao).getGameByTitle("RaceCar 3");
    }    GameViewModel gvm = new GameViewModel();
    private void setUpTShirtDaoMock() {
        tshirtDao = mock(TshirtJdbcTemplateImpl.class);

        Tshirt tShirt0 = new Tshirt();
        tShirt0.setColor("Red");
        tShirt0.setSize("L");
        tShirt0.setDescription("Large Red T-Shirt");
        tShirt0.setPrice(new BigDecimal("29.99").setScale(2));
        tShirt0.setQuantity(350);

        // Response T-Shirt
        Tshirt tShirt1 = new Tshirt();
        tShirt1.setTshirtId(12);
        tShirt1.setColor("Red");
        tShirt1.setSize("L");
        tShirt1.setDescription("Large Red T-Shirt");
        tShirt1.setPrice(new BigDecimal("29.99").setScale(2));
        tShirt1.setQuantity(350);

        // Updated T-Shirt
        Tshirt tShirt1Updated =  new Tshirt();
        tShirt1Updated.setTshirtId(12);
        tShirt1Updated.setColor("Blue");
        tShirt1Updated.setSize("L");
        tShirt1Updated.setDescription("Large Red T-Shirt");
        tShirt1Updated.setPrice(new BigDecimal("29.99").setScale(2));
        tShirt1Updated.setQuantity(350);

        // Additional T-Shirts
        Tshirt tShirt2 = new Tshirt();
        tShirt2.setTshirtId(32);
        tShirt2.setColor("Green");
        tShirt2.setSize("M");
        tShirt2.setDescription("Medium Green T-Shirt");
        tShirt2.setPrice(new BigDecimal("24.99").setScale(2));
        tShirt2.setQuantity(250);

        List<Tshirt> tShirts = new ArrayList<>();
        List<Tshirt> tShirtsByColor = new ArrayList<>();
        List<Tshirt> tShirtsBySize = new ArrayList<>();

        tShirts.add(tShirt1); tShirts.add(tShirt2);
        tShirtsByColor.add(tShirt1);
        tShirtsBySize.add(tShirt2);

        doReturn(tShirt1).when(tshirtDao).addTshirt(tShirt0);
        doReturn(tShirt1).when(tshirtDao).getTshirt(31);
        doReturn(tShirt1Updated).when(tshirtDao).updateTshirt(tShirt1Updated);
        doReturn(tShirts).when(tshirtDao).getAllTshirts();
        //doReturn(tShirtsByColor).when(tshirtDao).get("Red");
        //doReturn(tShirtsByColor).when(tshirtDao).getTShirtBySize("M");
    }

    private void setUpConsoleDaoMock() {
        consoleDao = mock(ConsoleJdbcTemplateImpl.class);

        //Request Console
        Console console0 = new Console();
        console0.setModel("Playstation");
        console0.setManufacturer("Sony");
        console0.setMemoryAmount("16GB");
        console0.setProcessor("Quad i7");
        console0.setPrice(new BigDecimal("319.99").setScale(2));
        console0.setQuantity(250);

        //Response Console
        Console console1 = new Console();
        console1.setModel("Playstation");
        console1.setManufacturer("Sony");
        console1.setMemoryAmount("16GB");
        console1.setProcessor("Quad i7");
        console1.setPrice(new BigDecimal("399.99").setScale(2));
        console1.setQuantity(250);
        console1.setConsoleId(21);

        //Updated Console
        Console console1Updated = new Console();
        console1Updated.setModel("Playstation");
        console1Updated.setManufacturer("Sony");
        console1Updated.setMemoryAmount("16GB");
        console1Updated.setProcessor("Quad i7");
        console1Updated.setPrice(new BigDecimal("349.99").setScale(2));
        console1Updated.setQuantity(250);
        console1Updated.setConsoleId(21);

        //Adding 2nd Console
        Console console2 = new Console();
        console2.setConsoleId(22);
        console2.setModel("xbox One");
        console2.setManufacturer("Microsoft");
        console2.setMemoryAmount("16GB");
        console2.setProcessor("Quad i7");
        console2.setPrice(new BigDecimal("399.99").setScale(2));
        console2.setQuantity(250);

        List<Console> consoles = new ArrayList<>();
        List<Console> consolesByManufacturer = new ArrayList<>();

        consoles.add(console1); consoles.add(console2);
        consolesByManufacturer.add(console1);

        doReturn(console1).when(consoleDao).addConsole(console0);
        doReturn(console1).when(consoleDao).getConsole(21);
        doReturn(console1Updated).when(consoleDao).updateConsole(console1Updated);
        doReturn(consoles).when(consoleDao).getAllConsoles();
        doReturn(consolesByManufacturer).when(consoleDao).getConsoleByManufacturer("Sony");
    }
    @Test
    public void removeConsole() {
    }
}