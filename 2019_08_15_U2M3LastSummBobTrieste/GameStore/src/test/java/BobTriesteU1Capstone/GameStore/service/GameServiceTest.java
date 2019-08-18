package BobTriesteU1Capstone.GameStore.service;

import BobTriesteU1Capstone.GameStore.dao.GameDao;
import BobTriesteU1Capstone.GameStore.dao.GameJdbcTemplateImpl;
import BobTriesteU1Capstone.GameStore.model.Game;
import BobTriesteU1Capstone.GameStore.viewmodel.GameViewModel;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class GameServiceTest {


    GameDao gameDao;
    GameService gameService;

    @Before
    public void setUp() throws Exception {
        setUpGameDaoMock();
        gameService = new GameService(gameDao);
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

    @Test
    public void saveFindUpdateGame() {
        GameViewModel gvm = new GameViewModel();
        gvm.setTitle("RaceCar");
        gvm.setDescription("RaceCar Desc");
        gvm.setStudio("Feral");
        gvm.setEsrb_rating("M");
        gvm.setPrice(new BigDecimal("59.99").setScale(2));
        gvm.setQuantity(500);

        //Add Game
        gvm = gameService.saveGame(gvm);

        //Find Game
        GameViewModel gameFromService = gameService.findGameById(gvm.getGameId());

        assertEquals(gvm, gameFromService);

        //Update Game
        gvm.setPrice(new BigDecimal("29.99").setScale(2));
        GameViewModel updatGameFromGameService = gameService.updateGame(gvm);

        assertEquals(gvm, updatGameFromGameService);
    }


    @Test
    public void findGameById() {
    }

    @Test
    public void removeGame() {
    }
}