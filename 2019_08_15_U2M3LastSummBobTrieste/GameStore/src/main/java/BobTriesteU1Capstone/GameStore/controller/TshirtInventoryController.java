package BobTriesteU1Capstone.GameStore.controller;


import BobTriesteU1Capstone.GameStore.exception.NotFoundException;
import BobTriesteU1Capstone.GameStore.service.ConsoleService;
import BobTriesteU1Capstone.GameStore.service.TshirtService;

import BobTriesteU1Capstone.GameStore.viewmodel.TshirtViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/tshirt")//This mapping at class level allows to set the base path for the Customer API
public class TshirtInventoryController {

    @Autowired
    TshirtService tshirtService;

    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    TshirtViewModel getTShirt(@PathVariable int id){
        return tshirtService.findTShirt(id);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    List<TshirtViewModel> getAllTShirts(){ return tshirtService.findAllTShirts();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    String deleteTShirt(@PathVariable int id){
        return tshirtService.removeTshirt(id);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    TshirtViewModel addTShirt(@RequestBody @Valid TshirtViewModel tShirtViewModel){
        return tshirtService.saveTshirt(tShirtViewModel);
    }

    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.CREATED)
    TshirtViewModel updateTShirt(@RequestBody @Valid TshirtViewModel tShirtViewModel, @PathVariable int id){
        if(id!=tShirtViewModel.getTshirtId()){
            throw new IllegalArgumentException("Ids in path and request body don't match!");
        }
        return tshirtService.updateTshirt(tShirtViewModel);
    }

    @GetMapping("/color/{color}")
    @ResponseStatus(value = HttpStatus.OK)
    List<TshirtViewModel> getTshirtByColor(@PathVariable String color){
        return tshirtService.findTShirtsByColor(color);
    }


}
//
//        @Autowired
//        TshirtService tshirtService;
//
//        @PostMapping//Another way to set the Rest API Post mapping
//        @ResponseStatus(HttpStatus.CREATED)
//        public TshirtViewModel addTshirt(@RequestBody @Valid TshirtViewModel tshirt) {
//            return tshirtService.saveTshirt(tshirt);
//        }
//
//
//        @GetMapping("/color/{color}")
//        @ResponseStatus(value = HttpStatus.OK)
//        List<TshirtViewModel> getTShirtByColor(@PathVariable String color){
//            return TshirtViewModel.f(color);
//        }
//
//        @DeleteMapping("/{id}")//Another way to set the Rest API Delete mapping
//        @ResponseStatus(HttpStatus.NO_CONTENT)
//        public void deleteConsole(@PathVariable("id") int id) {
//            tshirtService.removeTshirt(id);
//        }
//
//
//        @PutMapping("/{id}")//Another way to set the Rest API Put mapping
//        @ResponseStatus(HttpStatus.NO_CONTENT)
//        public void updateTshirt(@PathVariable("id") int id, @RequestBody @Valid TshirtViewModel tshirtViewModel) {
//            if (tshirtViewModel.getTshirtId() == 0)
//                tshirtViewModel.setTshirtId(id);
//            if (id != tshirtViewModel.getTshirtId()) {
//                throw new IllegalArgumentException("Tshirt ID on path must match the ID in the Customer object");
//            }
//            tshirtService.updateTshirt(tshirtViewModel);
//        }
//
//    }


