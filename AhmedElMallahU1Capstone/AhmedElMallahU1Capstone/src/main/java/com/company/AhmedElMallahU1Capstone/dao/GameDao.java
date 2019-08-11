package com.company.AhmedElMallahU1Capstone.dao;

import com.company.AhmedElMallahU1Capstone.dto.Game;

import java.util.List;

public interface GameDao {

    //CRUD Methods
    Game addGame(Game game);
    Game getGame(int id);
    List<Game> getAllGames();
    Game updateGame(Game game);
    void deleteGame(int id);

    //Custom Methods
    List<Game> getGameByStudio(String studio);
    List<Game> getGameByErsbRating(String ersbRating);
    List<Game> getGameByTitle(String title);

}
