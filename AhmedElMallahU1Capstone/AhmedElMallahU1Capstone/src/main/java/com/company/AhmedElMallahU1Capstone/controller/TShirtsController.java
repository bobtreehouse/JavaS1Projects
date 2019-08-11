package com.company.AhmedElMallahU1Capstone.controller;

import com.company.AhmedElMallahU1Capstone.service.ServiceLayer;
import com.company.AhmedElMallahU1Capstone.viewmodel.ConsoleViewModel;
import com.company.AhmedElMallahU1Capstone.viewmodel.TShirtViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/tshirts")
public class TShirtsController {

    @Autowired
    ServiceLayer serviceLayer;

    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    TShirtViewModel getTShirt(@PathVariable int id){
        return serviceLayer.findTShirt(id);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    List<TShirtViewModel> getAllTShirts(){
        return serviceLayer.findAllTShirts();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    String deleteTShirt(@PathVariable int id){
        return serviceLayer.removeTShirt(id);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    TShirtViewModel addTShirt(@RequestBody @Valid TShirtViewModel tShirtViewModel){
        return serviceLayer.saveTShirt(tShirtViewModel);
    }

    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.CREATED)
    TShirtViewModel updateTShirt(@RequestBody @Valid TShirtViewModel tShirtViewModel, @PathVariable int id){
        if(id!=tShirtViewModel.getId()){
            throw new IllegalArgumentException("Ids in path and request body don't match!");
        }
        return serviceLayer.updateTShirt(tShirtViewModel);
    }

    @GetMapping("/color/{color}")
    @ResponseStatus(value = HttpStatus.OK)
    List<TShirtViewModel> getTShirtByColor(@PathVariable String color){
        return serviceLayer.findTShirtsByColor(color);
    }

    @GetMapping("/size/{size}")
    @ResponseStatus(value = HttpStatus.OK)
    List<TShirtViewModel> getTShirtBySize(@PathVariable String size){
        return serviceLayer.findTShirtsBySize(size);
    }
}