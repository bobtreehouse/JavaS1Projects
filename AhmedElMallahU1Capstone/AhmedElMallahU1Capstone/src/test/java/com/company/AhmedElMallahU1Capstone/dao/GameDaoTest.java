package com.company.AhmedElMallahU1Capstone.dao;

import com.company.AhmedElMallahU1Capstone.dto.Game;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GameDaoTest {

    @Autowired
    private GameDao gameDao;

    @Before
    public void setUp() throws Exception {
        //Cleaning Test DB
        List<Game> games = gameDao.getAllGames();
        games.stream().forEach(game -> gameDao.deleteGame(game.getId()));
    }

    @Test
    public void addGetDeleteGame() {
        //Adding Game
        Game game = new Game();
        game.setTitle("Tomb Raider");
        game.setDescription("Tomb Raider Desc");
        game.setStudio("Feral interactive");
        game.setErsbRating("R");
        game.setPrice(new BigDecimal("59.99").setScale(2));
        game.setQuantity(500);

        //Add Dao
        Game addDaoGame = gameDao.addGame(game);

        //GetDao
        Game getDaoGame = gameDao.getGame(addDaoGame.getId());

        assertEquals(addDaoGame, getDaoGame);

        //Delete Dao
        gameDao.deleteGame(getDaoGame.getId());

        getDaoGame = gameDao.getGame(getDaoGame.getId());

        assertNull(getDaoGame);
    }

    @Test
    public void updateGame() {
        //Adding Game
        Game game = new Game();
        game.setTitle("Tomb Raider");
        game.setDescription("Tomb Raider Desc");
        game.setStudio("Feral interactive");
        game.setErsbRating("R");
        game.setPrice(new BigDecimal("59.99").setScale(2));
        game.setQuantity(500);
        game = gameDao.addGame(game);

        //Changing ERSB Rating
        game.setErsbRating("M");

        //UpdateDao
        Game updateDaoGame = gameDao.updateGame(game);

        assertEquals(game,updateDaoGame);
    }

    @Test
    public void getAllGamesAndByStudioAndByErsbAndByTitle() {
        //Adding Game
        Game game = new Game();
        game.setTitle("Tomb Raider");
        game.setDescription("Tomb Raider Desc");
        game.setStudio("Feral");
        game.setErsbRating("R");
        game.setPrice(new BigDecimal("59.99").setScale(2));
        game.setQuantity(500);
        game = gameDao.addGame(game);

        //Adding 2nd Game
        Game game2 = new Game();
        game2.setTitle("Tomb Raider 2");
        game2.setDescription("Tomb Raider 2 Desc");
        game2.setStudio("Feral");
        game2.setErsbRating("M");
        game2.setPrice(new BigDecimal("59.99").setScale(2));
        game2.setQuantity(500);
        game2 = gameDao.addGame(game2);

        //Adding 3rd Game
        Game game3 = new Game();
        game3.setTitle("Tomb Raider 3");
        game3.setDescription("Tomb Raider 3 Desc");
        game3.setStudio("Sony");
        game3.setErsbRating("R");
        game3.setPrice(new BigDecimal("59.99").setScale(2));
        game3.setQuantity(500);
        game3 = gameDao.addGame(game3);

        //GetAll
        List<Game> allGames = gameDao.getAllGames();

        //GetByTitle
        List<Game> gamesCalledTombRaider = gameDao.getGameByTitle("Tomb Raider");

        //GetByTitle
        List<Game> gamesRatedR = gameDao.getGameByErsbRating("R");

        //GetByTitle
        List<Game> gamesByFeral = gameDao.getGameByStudio("Feral");

        //Asserts
        assertEquals(allGames.size(),3);
        assertEquals(gamesCalledTombRaider.size(), 1);
        assertEquals(gamesRatedR.size(),2);
        assertEquals(gamesByFeral.size(),2);
    }
}