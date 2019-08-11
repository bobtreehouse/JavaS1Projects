package com.company.AhmedElMallahU1CapstoneJPA.controller;

import com.company.AhmedElMallahU1CapstoneJPA.service.ServiceLayer;
import com.company.AhmedElMallahU1CapstoneJPA.viewmodel.GameViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GamesController {

    @Autowired
    ServiceLayer serviceLayer;

    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    GameViewModel getGame(@PathVariable int id){
        return serviceLayer.findGame(id);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    List<GameViewModel> getAllGames(){
        return serviceLayer.findAllGames();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    String deleteGame(@PathVariable int id){
        return serviceLayer.removeGame(id);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    GameViewModel addGame(@RequestBody @Valid GameViewModel gameViewModel){
        return serviceLayer.saveGame(gameViewModel);
    }

    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.CREATED)
    GameViewModel updateGame(@RequestBody @Valid GameViewModel gameViewModel, @PathVariable int id){
        if(id!=gameViewModel.getId()){
            throw new IllegalArgumentException("Ids in path and request body don't match!");
        }
        return serviceLayer.updateGame(gameViewModel);
    }

    @GetMapping("/studio/{studio}")
    @ResponseStatus(value = HttpStatus.OK)
    List<GameViewModel> getGameByStudio(@PathVariable String studio){
        return serviceLayer.findGamesByStudio(studio);
    }

    @GetMapping("/ersb/{ersb_rating}")
    @ResponseStatus(value = HttpStatus.OK)
    List<GameViewModel> getGameByErsb(@PathVariable String ersb_rating){
        return serviceLayer.findGamesByErsbRating(ersb_rating);
    }

    @GetMapping("/title/{title}")
    @ResponseStatus(value = HttpStatus.OK)
    List<GameViewModel> getGameByTitle(@PathVariable String title){
        return serviceLayer.findGamesByTitle(title);
    }
}
