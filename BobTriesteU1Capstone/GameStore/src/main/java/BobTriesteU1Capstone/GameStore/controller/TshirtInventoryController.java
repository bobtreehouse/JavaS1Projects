package BobTriesteU1Capstone.GameStore.controller;


import BobTriesteU1Capstone.GameStore.exception.NotFoundException;
import BobTriesteU1Capstone.GameStore.service.ConsoleService;
import BobTriesteU1Capstone.GameStore.service.TshirtService;

import BobTriesteU1Capstone.GameStore.viewmodel.TshirtViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
//public class TshirtInventoryController {

    @RestController
    @RequestMapping("/tshirt")//This mapping at class level allows to set the base path for the Customer API
    public class TshirtInventoryController {

        @Autowired
        TshirtService tshirtService;

        @PostMapping//Another way to set the Rest API Post mapping
        @ResponseStatus(HttpStatus.CREATED)
        public TshirtViewModel addTshirt(@RequestBody @Valid TshirtViewModel tshirt) {
            return tshirtService.saveTshirt(tshirt);
        }

        @GetMapping("/{id}")//Another way to set the Rest API Get mapping
        @ResponseStatus(HttpStatus.OK)
        public TshirtViewModel getTshirt(@PathVariable("id") int tshirtId) {
            TshirtViewModel tshirtViewModel = TshirtService.getTshirtByColor(tshirtId);
            if (tshirtViewModel == null)
                throw new NotFoundException("Tshirt could not be retrieved for id " + tshirtId);
            return tshirtViewModel;
        }

        @DeleteMapping("/{id}")//Another way to set the Rest API Delete mapping
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void deleteConsole(@PathVariable("id") int id) {
            tshirtService.removeTshirt(id);
        }


        @PutMapping("/{id}")//Another way to set the Rest API Put mapping
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void updateTshirt(@PathVariable("id") int id, @RequestBody @Valid TshirtViewModel tshirtViewModel) {
            if (tshirtViewModel.getTshirtId() == 0)
                tshirtViewModel.setTshirtId(id);
            if (id != tshirtViewModel.getTshirtId()) {
                throw new IllegalArgumentException("Tshirt ID on path must match the ID in the Customer object");
            }
            tshirtService.updateTshirt(tshirtViewModel);
        }

    }


