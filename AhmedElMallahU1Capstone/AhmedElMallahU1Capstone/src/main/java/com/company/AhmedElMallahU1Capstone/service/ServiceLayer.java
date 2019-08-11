package com.company.AhmedElMallahU1Capstone.service;

import com.company.AhmedElMallahU1Capstone.dao.*;
import com.company.AhmedElMallahU1Capstone.dto.*;
import com.company.AhmedElMallahU1Capstone.viewmodel.ConsoleViewModel;
import com.company.AhmedElMallahU1Capstone.viewmodel.GameViewModel;
import com.company.AhmedElMallahU1Capstone.viewmodel.InvoiceViewModel;
import com.company.AhmedElMallahU1Capstone.viewmodel.TShirtViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Component
public class ServiceLayer {

    private GameDao gameDao;
    private ConsoleDao consoleDao;
    private TShirtDao tShirtDao;
    private InvoiceDao invoiceDao;
    private TaxRateDao taxRateDao;
    private ProcessingFeeDao processingFeeDao;

    @Autowired
    public ServiceLayer(GameDao gameDao, ConsoleDao consoleDao, TShirtDao tShirtDao, InvoiceDao invoiceDao, TaxRateDao taxRateDao, ProcessingFeeDao processingFeeDao) {
        this.gameDao = gameDao;
        this.consoleDao = consoleDao;
        this.tShirtDao = tShirtDao;
        this.invoiceDao = invoiceDao;
        this.taxRateDao = taxRateDao;
        this.processingFeeDao = processingFeeDao;
    }

    //
    // Games API
    //
    public GameViewModel saveGame(GameViewModel gameViewModel){
        Game game = new Game();
        game.setTitle(gameViewModel.getTitle());
        game.setErsbRating(gameViewModel.getErsbRating());
        game.setDescription(gameViewModel.getDescription());
        game.setStudio(gameViewModel.getStudio());
        game.setPrice(gameViewModel.getPrice());
        game.setQuantity(gameViewModel.getQuantity());

        game = gameDao.addGame(game);

        gameViewModel.setId(game.getId());

        return gameViewModel;
    }

    public GameViewModel findGame(int id){
        Game game = gameDao.getGame(id);
        return buildGameViewModel(game);
    }

    public List<GameViewModel> findAllGames(){

        List<Game> games = gameDao.getAllGames();
        List<GameViewModel> gvmList = new ArrayList<>();
        games.stream().forEach(game -> {
            GameViewModel gvm = buildGameViewModel(game);
            gvmList.add(gvm);
        });

        return gvmList;
    }

    public List<GameViewModel> findGamesByStudio(String studio){
        List<Game> games = gameDao.getGameByStudio(studio);
        List<GameViewModel> gvmList = new ArrayList<>();
        games.stream().forEach(game -> {
            GameViewModel gvm = buildGameViewModel(game);
            gvmList.add(gvm);
        });

        return gvmList;
    }

    public List<GameViewModel> findGamesByErsbRating(String ersbRating){
        List<Game> games = gameDao.getGameByErsbRating(ersbRating);
        List<GameViewModel> gvmList = new ArrayList<>();
        games.stream().forEach(game -> {
            GameViewModel gvm = buildGameViewModel(game);
            gvmList.add(gvm);
        });

        return gvmList;
    }

    public List<GameViewModel> findGamesByTitle(String title){
        List<Game> games = gameDao.getGameByTitle(title);
        List<GameViewModel> gvmList = new ArrayList<>();
        games.stream().forEach(game -> {
            GameViewModel gvm = buildGameViewModel(game);
            gvmList.add(gvm);
        });

        return gvmList;
    }

    public GameViewModel updateGame(GameViewModel gameViewModel){
        Game game = new Game();
        game.setId(gameViewModel.getId());
        game.setTitle(gameViewModel.getTitle());
        game.setErsbRating(gameViewModel.getErsbRating());
        game.setDescription(gameViewModel.getDescription());
        game.setStudio(gameViewModel.getStudio());
        game.setPrice(gameViewModel.getPrice());
        game.setQuantity(gameViewModel.getQuantity());

        game = gameDao.updateGame(game);

        return buildGameViewModel(game);
    }

    public String removeGame(int id){
        gameDao.deleteGame(id);
        return "Game ["+id+"] was deleted successfully.";
    }

    //
    // Console API
    //
    public ConsoleViewModel saveConsole(ConsoleViewModel consoleViewModel){
        Console console = new Console();
        console.setModel(consoleViewModel.getModel());
        console.setManufacturer(consoleViewModel.getManufacturer());
        console.setMemoryAmount(consoleViewModel.getMemoryAmount());
        console.setProcessor(consoleViewModel.getProcessor());
        console.setPrice(consoleViewModel.getPrice());
        console.setQuantity(consoleViewModel.getQuantity());

        console = consoleDao.addConsole(console);

        consoleViewModel.setId(console.getId());

        return consoleViewModel;
    }

    public ConsoleViewModel findConsole(int id){
        Console console = consoleDao.getConsole(id);
        return buildConsoleViewModel(console);
    }

    public List<ConsoleViewModel> findAllConsoles(){
        List<Console> consoles = consoleDao.getAllConsoles();
        List<ConsoleViewModel> cvmList = new ArrayList<>();
        consoles.stream().forEach(console -> {
            ConsoleViewModel cvm = buildConsoleViewModel(console);
            cvmList.add(cvm);
        });

        return cvmList;
    }

    public List<ConsoleViewModel> findConsolesByManufacturer(String manufacturer){
        List<Console> consoles = consoleDao.getConsoleByManufacturer(manufacturer);
        List<ConsoleViewModel> cvmList = new ArrayList<>();
        consoles.stream().forEach(console -> {
            ConsoleViewModel cvm = buildConsoleViewModel(console);
            cvmList.add(cvm);
        });

        return cvmList;
    }

    public ConsoleViewModel updateConsole(ConsoleViewModel consoleViewModel){
        Console console = new Console();
        console.setId(consoleViewModel.getId());
        console.setModel(consoleViewModel.getModel());
        console.setManufacturer(consoleViewModel.getManufacturer());
        console.setMemoryAmount(consoleViewModel.getMemoryAmount());
        console.setProcessor(consoleViewModel.getProcessor());
        console.setPrice(consoleViewModel.getPrice());
        console.setQuantity(consoleViewModel.getQuantity());

        console = consoleDao.updateConsole(console);

        return buildConsoleViewModel(console);
    }

    public String removeConsole(int id){
        consoleDao.deleteConsole(id);
        return "Console ["+id+"] was deleted successfully.";
    }

    //
    // T-Shirt API
    //
    public TShirtViewModel saveTShirt(TShirtViewModel tShirtViewModel){

        TShirt tShirt = new TShirt();//Console console = new Console();
        tShirt.setSize(tShirtViewModel.getSize());
        tShirt.setColor(tShirtViewModel.getColor());
        tShirt.setDescription(tShirtViewModel.getDescription());
        tShirt.setPrice(tShirtViewModel.getPrice());
        tShirt.setQuantity(tShirtViewModel.getQuantity());

        tShirt = tShirtDao.addTShirt(tShirt);

        tShirtViewModel.setId(tShirt.getId());

        return tShirtViewModel;
    }

    public TShirtViewModel findTShirt(int id){
        TShirt tShirt = tShirtDao.getTShirt(id);
        return buildTShirtViewModel(tShirt);
    }

    public List<TShirtViewModel> findAllTShirts(){
        List<TShirt> tShirts = tShirtDao.getAllTShirts();
        List<TShirtViewModel> tvmList = new ArrayList<>();
        tShirts.stream().forEach(tShirt -> {
            TShirtViewModel tvm = buildTShirtViewModel(tShirt);
            tvmList.add(tvm);
        });

        return tvmList;
    }

    public List<TShirtViewModel> findTShirtsByColor(String color){
        List<TShirt> tShirts = tShirtDao.getTShirtByColor(color);
        List<TShirtViewModel> tvmList = new ArrayList<>();
        tShirts.stream().forEach(tShirt -> {
            TShirtViewModel tvm = buildTShirtViewModel(tShirt);
            tvmList.add(tvm);
        });

        return tvmList;
    }

    public List<TShirtViewModel> findTShirtsBySize(String size){
        List<TShirt> tShirts = tShirtDao.getTShirtBySize(size);
        List<TShirtViewModel> tvmList = new ArrayList<>();
        tShirts.stream().forEach(tShirt -> {
            TShirtViewModel tvm = buildTShirtViewModel(tShirt);
            tvmList.add(tvm);
        });

        return tvmList;
    }

    public TShirtViewModel updateTShirt(TShirtViewModel tShirtViewModel){

        TShirt tShirt = new TShirt();//Console console = new Console();
        tShirt.setId(tShirtViewModel.getId());
        tShirt.setSize(tShirtViewModel.getSize());
        tShirt.setColor(tShirtViewModel.getColor());
        tShirt.setDescription(tShirtViewModel.getDescription());
        tShirt.setPrice(tShirtViewModel.getPrice());
        tShirt.setQuantity(tShirtViewModel.getQuantity());

        tShirt = tShirtDao.updateTShirt(tShirt);

        return buildTShirtViewModel(tShirt);
    }

    public String removeTShirt(int id){
        tShirtDao.deleteTShirt(id);
        return "T-Shirt ["+id+"] was deleted successfully.";
    }

    //
    // Invoice API
    //
    @Transactional
    public InvoiceViewModel saveInvoice(InvoiceViewModel invoiceViewModel){

        //Persist Invoice Dto
        Invoice invoice = new Invoice();
        invoice.setName(invoiceViewModel.getName());
        invoice.setStreet(invoiceViewModel.getStreet());
        invoice.setCity(invoiceViewModel.getCity());
        invoice.setState(invoiceViewModel.getState());
        invoice.setZipcode(invoiceViewModel.getZipcode());
        invoice.setItemType(invoiceViewModel.getItemType());
        invoice.setItemId(invoiceViewModel.getItemId());
        invoice.setQuantity(invoiceViewModel.getQuantity());

        // Getting Item Information
        // 4. The order process logic must properly update the quantity on hand for the item in the order.
        // 6. Order quantity must be less than or equal to the number of items on hand in inventory.

        BigDecimal itemPrice;

        if(invoice.getItemType().equals("Consoles")){
            Console item = consoleDao.getConsole(invoice.getItemId());
            int itemQuantity = item.getQuantity();
            itemPrice = item.getPrice();
            // 6. Order quantity must be less than or equal to the number of items on hand in inventory.
            if(invoice.getQuantity()>itemQuantity){
                throw new IllegalArgumentException("Not enough items on hand.");
            } else {
                item.setQuantity(itemQuantity-invoice.getQuantity());
                consoleDao.updateConsole(item);
            }
        }else if(invoice.getItemType().equals("T-Shirts")){
            TShirt item = tShirtDao.getTShirt(invoice.getItemId());
            int itemQuantity = item.getQuantity();
            itemPrice = item.getPrice();
            // 6. Order quantity must be less than or equal to the number of items on hand in inventory.
            if(invoice.getQuantity()>itemQuantity){
                throw new IllegalArgumentException("Not enough items on hand.");
            } else {
                item.setQuantity(itemQuantity-invoice.getQuantity());
                tShirtDao.updateTShirt(item);
            }
        }else if(invoice.getItemType().equals("Games")){
            Game item = gameDao.getGame(invoice.getItemId());
            int itemQuantity = item.getQuantity();
            itemPrice = item.getPrice();
            // 6. Order quantity must be less than or equal to the number of items on hand in inventory.
            if(invoice.getQuantity()>itemQuantity){
                throw new IllegalArgumentException("Not enough items on hand.");
            } else {
                item.setQuantity(itemQuantity-invoice.getQuantity());
                gameDao.updateGame(item);
            }
        } else {
            throw new IllegalArgumentException("Item type not correct! Please choose [Games], [T-Shirts], or [Consoles].");
        }

        // Setting Unit Price
        invoice.setUnitPrice(itemPrice.setScale(2));

        //Getting Tax_Rate and processing_Fees
        BigDecimal taxRate = taxRateDao.getByState(invoice.getState()).getRate();
        BigDecimal processingFee = processingFeeDao.getByItemType(invoice.getItemType()).getFee();

        // Calculating Subtotal
        invoice.setSubtotal(BigDecimal.valueOf( invoice.getQuantity() ).multiply( invoice.getUnitPrice() ).setScale(2));

        // Calculating Tax
        invoice.setTax(taxRate.multiply(invoice.getSubtotal()).setScale(2, RoundingMode.HALF_UP));

        // Calculating Processing Fee
        if(invoice.getQuantity()>10){
            invoice.setProcessingFee(new BigDecimal("15.49").setScale(2).add(processingFee).setScale(2));
        } else {
            invoice.setProcessingFee(processingFee.setScale(2));
        }

        // Calculating Total
        invoice.setTotal(invoice.getSubtotal().add(invoice.getTax()).add(invoice.getProcessingFee()).setScale(2));

        //Add to DB
        invoice = invoiceDao.addInvoice(invoice);

        return buildInvoiceViewModel(invoice);
    }


    ////////////////// Helper Methods //////////////////
    //
    // GameViewModel
    //
    private GameViewModel buildGameViewModel(Game game){
        //Assemble gameViewModel
        GameViewModel gameViewModel = new GameViewModel();
        gameViewModel.setId(game.getId());
        gameViewModel.setTitle(game.getTitle());
        gameViewModel.setErsbRating(game.getErsbRating());
        gameViewModel.setDescription(game.getDescription());
        gameViewModel.setStudio(game.getStudio());
        gameViewModel.setPrice(game.getPrice());
        gameViewModel.setQuantity(game.getQuantity());

        return gameViewModel;
    }

    //
    // ConsoleViewModel
    //
    private ConsoleViewModel buildConsoleViewModel(Console console){
        //Assemble consoleViewModel
        ConsoleViewModel consoleViewModel = new ConsoleViewModel();
        consoleViewModel.setId(console.getId());
        consoleViewModel.setModel(console.getModel());
        consoleViewModel.setManufacturer(console.getManufacturer());
        consoleViewModel.setMemoryAmount(console.getMemoryAmount());
        consoleViewModel.setProcessor(console.getProcessor());
        consoleViewModel.setPrice(console.getPrice());
        consoleViewModel.setQuantity(console.getQuantity());

        return consoleViewModel;
    }

    //
    // TShirtViewModel
    //
    private TShirtViewModel buildTShirtViewModel(TShirt tShirt){
        //Assemble tShirtViewModel
        TShirtViewModel tShirtViewModel = new TShirtViewModel();
        tShirtViewModel.setId(tShirt.getId());
        tShirtViewModel.setSize(tShirt.getSize());
        tShirtViewModel.setColor(tShirt.getColor());
        tShirtViewModel.setDescription(tShirt.getDescription());
        tShirtViewModel.setPrice(tShirt.getPrice());
        tShirtViewModel.setQuantity(tShirt.getQuantity());

        return tShirtViewModel;
    }

    //
    // InvoiceViewModel
    //
    private InvoiceViewModel buildInvoiceViewModel(Invoice invoice){
        //Assemble invoiceViewModel
        InvoiceViewModel invoiceViewModel = new InvoiceViewModel();
        invoiceViewModel.setId(invoice.getId());
        invoiceViewModel.setName(invoice.getName());
        invoiceViewModel.setStreet(invoice.getStreet());
        invoiceViewModel.setCity(invoice.getCity());
        invoiceViewModel.setState(invoice.getState());
        invoiceViewModel.setZipcode(invoice.getZipcode());
        invoiceViewModel.setItemType(invoice.getItemType());
        invoiceViewModel.setItemId(invoice.getItemId());
        invoiceViewModel.setUnitPrice(invoice.getUnitPrice());
        invoiceViewModel.setQuantity(invoice.getQuantity());
        invoiceViewModel.setSubtotal(invoice.getSubtotal());
        invoiceViewModel.setTax(invoice.getTax());
        invoiceViewModel.setProcessingFee(invoice.getProcessingFee());
        invoiceViewModel.setTotal(invoice.getTotal());

        return invoiceViewModel;
    }
}
