package BobTriesteU1Capstone.GameStore.dao;


import BobTriesteU1Capstone.GameStore.model.Game;

import java.util.List;

public interface GameDao {


    Game addGame(Game game);

    Game getGame(int id);

    List<Game> getAllGames();



    List<Game> getGameByESRBRating(String string);

    List<Game> getGameByTitle(String string);

    Game updateGame(Game game);

    List<Game> getGamesByStudio(String studio);

    void deleteGame(int id);


}


