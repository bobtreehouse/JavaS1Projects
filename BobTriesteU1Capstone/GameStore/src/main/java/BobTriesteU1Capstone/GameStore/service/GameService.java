package BobTriesteU1Capstone.GameStore.service;

import BobTriesteU1Capstone.GameStore.dao.*;
import BobTriesteU1Capstone.GameStore.model.*;
import BobTriesteU1Capstone.GameStore.viewmodel.*;
import BobTriesteU1Capstone.GameStore.model.Game;
import BobTriesteU1Capstone.GameStore.viewmodel.GameViewModel;
import java.util.ArrayList;
import java.util.List;
import BobTriesteU1Capstone.GameStore.dao.TshirtDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component

public class GameService {

    ConsoleDao consoleDao;
    GameDao gameDao;
    InvoiceDao invoiceDao;
    ProcessingFeeDao processingFeeDao;
    SalesTaxRateDao salesTaxRateDao;
    TshirtDao tshirtDao;


    @Autowired
    public GameService(ConsoleDao consoleDao, GameDao gameDao, InvoiceDao invoiceDao, ProcessingFeeDao processingFeeDao,
                                   SalesTaxRateDao salesTaxRateDao, TshirtDao tshirtDao) {
        this.consoleDao = consoleDao;
        this.gameDao = gameDao;
        this.invoiceDao = invoiceDao;
        this.processingFeeDao = processingFeeDao;
        this.salesTaxRateDao = salesTaxRateDao;
    }


    public GameViewModel saveGame(GameViewModel gameViewModel) {
        Game game = new Game();

        game.setTitle(gameViewModel.getTitle());
        game.setEsrb_rating(gameViewModel.getEsrb_rating());
        game.setDescription(gameViewModel.getDescription());
        game.setStudio(gameViewModel.getStudio());
        game.setPrice(gameViewModel.getPrice());
        game.setQuantity(game.getQuantity());

        game =  gameDao.addGame(game);

        gameViewModel.setGameId(game.getGameId());
        return gameViewModel;
    }

    public void updateGame(GameViewModel gameViewModel) {

        Game game = new Game();

        game.setTitle(gameViewModel.getTitle());
        game.setEsrb_rating(gameViewModel.getEsrb_rating());
        game.setDescription(gameViewModel.getDescription());
        game.setStudio(gameViewModel.getStudio());
        game.setPrice(gameViewModel.getPrice());
        game.setQuantity(game.getQuantity());

        gameDao.updateGame(game);

    }

    private GameViewModel buildGameViewModel(Game game) {
        GameViewModel gameViewModel = new GameViewModel();
        gameViewModel.setDescription(game.getDescription());
        gameViewModel.setEsrb_rating(game.getEsrb_rating());
        gameViewModel.setStudio(game.getStudio());
        gameViewModel.setTitle(game.getTitle());
        gameViewModel.setPrice(game.getPrice());
        gameViewModel.setStudio(game.getStudio());
        gameViewModel.setQuantity(game.getQuantity());
        return gameViewModel;
    }

    public GameViewModel findGameById(int id) {
        Game game = consoleDao.getConsole(int id);
        if (game == null)
            return null;
        else
            return buildGameViewModel(game);
    }

    public void removeCGame(int id) {
        gameDao.deleteGame(int id);
    }
}