package BobTriesteU1Capstone.GameStore.controller;

import BobTriesteU1Capstone.GameStore.exception.NotFoundException;
import BobTriesteU1Capstone.GameStore.service.GameService;
import BobTriesteU1Capstone.GameStore.viewmodel.GameViewModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

//public class GameInventoryController {


    @RestController
    @RequestMapping("/game")//This mapping at class level allows to set the base path for the Customer API
    public class GameInventoryController {

        @Autowired
        GameService gameService;

        @PostMapping//Another way to set the Rest API Post mapping
        @ResponseStatus(HttpStatus.CREATED)
        public GameViewModel addConsole(@RequestBody @Valid GameViewModel game) {
            return gameService.saveGame(game);
        }

        @GetMapping("/{id}")//Another way to set the Rest API Get mapping
        @ResponseStatus(HttpStatus.OK)
        public GameViewModel getConsole(@PathVariable("id") int GameId) {
            GameViewModel gameViewModel = gameService.findGameById(GameId);
            if (gameViewModel == null)
                throw new NotFoundException("Customer could not be retrieved for id " + GameId);
            return gameViewModel;
        }

        @DeleteMapping("/{id}")//Another way to set the Rest API Delete mapping
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void deleteGame(@PathVariable("id") int id) {
            gameService.removeGame(id);
        }


        @PutMapping("/{id}")//Another way to set the Rest API Put mapping
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void updateCustomer(@PathVariable("id") int id, @RequestBody @Valid GameViewModel gameViewModel) {
            if (gameViewModel.getGameId() == 0)
                gameViewModel.setGameId(id);
            if (id != gameViewModel.getGameId()) {
                throw new IllegalArgumentException("Customer ID on path must match the ID in the Customer object");
            }
            gameService.updateGame(gameViewModel);
        }

    }
//}

