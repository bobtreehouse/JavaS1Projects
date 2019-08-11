package com.company.AhmedElMallahU1CapstoneJPA.dao;

import com.company.AhmedElMallahU1CapstoneJPA.dto.Game;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GameRepositoryTest {

    @Autowired
    GameRepository gameRepository;

    @Before
    public void setUp() throws Exception {
        gameRepository.deleteAll();
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
        Game addGame = gameRepository.save(game);

        //GetDao
        Game getGame = gameRepository.findById(game.getId()).get();

        assertEquals(addGame, getGame);

        //Delete Dao
        gameRepository.deleteById(getGame.getId());

        try {
            getGame = gameRepository.findById(getGame.getId()).get();
        } catch (NoSuchElementException e){
            getGame = null;
        }

        assertNull(getGame);
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
        game = gameRepository.save(game);

        //Changing ERSB Rating
        game.setErsbRating("M");

        //UpdateDao
        Game updatedGame = gameRepository.save(game);

        assertEquals(game,updatedGame);
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
        game = gameRepository.save(game);

        //Adding 2nd Game
        Game game2 = new Game();
        game2.setTitle("Tomb Raider 2");
        game2.setDescription("Tomb Raider 2 Desc");
        game2.setStudio("Feral");
        game2.setErsbRating("M");
        game2.setPrice(new BigDecimal("59.99").setScale(2));
        game2.setQuantity(500);
        game2 = gameRepository.save(game2);

        //Adding 3rd Game
        Game game3 = new Game();
        game3.setTitle("Tomb Raider 3");
        game3.setDescription("Tomb Raider 3 Desc");
        game3.setStudio("Sony");
        game3.setErsbRating("R");
        game3.setPrice(new BigDecimal("59.99").setScale(2));
        game3.setQuantity(500);
        game3 = gameRepository.save(game3);

        //GetAll
        List<Game> allGames = gameRepository.findAll();

        //GetByTitle
        List<Game> gamesCalledTombRaider = gameRepository.findByTitle("Tomb Raider");

        //GetByTitle
        List<Game> gamesRatedR = gameRepository.findByErsbRating("R");

        //GetByTitle
        List<Game> gamesByFeral = gameRepository.findByStudio("Feral");

        //Asserts
        assertEquals(allGames.size(),3);
        assertEquals(gamesCalledTombRaider.size(), 1);
        assertEquals(gamesRatedR.size(),2);
        assertEquals(gamesByFeral.size(),2);
    }
}