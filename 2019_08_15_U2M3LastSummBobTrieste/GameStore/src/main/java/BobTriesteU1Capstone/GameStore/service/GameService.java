package BobTriesteU1Capstone.GameStore.service;

import BobTriesteU1Capstone.GameStore.dao.*;
import BobTriesteU1Capstone.GameStore.model.Game;
import BobTriesteU1Capstone.GameStore.viewmodel.GameViewModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class GameService {

    GameDao gameDao;


    @Autowired
    public GameService(GameDao gameDao) {

        this.gameDao = gameDao;

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

    public GameViewModel updateGame(GameViewModel gameViewModel) {

        Game game = new Game();

        game.setTitle(gameViewModel.getTitle());
        game.setEsrb_rating(gameViewModel.getEsrb_rating());
        game.setDescription(gameViewModel.getDescription());
        game.setStudio(gameViewModel.getStudio());
        game.setPrice(gameViewModel.getPrice());
        game.setQuantity(game.getQuantity());

        gameDao.updateGame(game);

        return gameViewModel;
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
        Game game = gameDao.getGame(id);
        if (game == null)
            return null;
        else
            return buildGameViewModel(game);
    }

    public void removeGame(int id) {
        gameDao.deleteGame(id);
    }
}