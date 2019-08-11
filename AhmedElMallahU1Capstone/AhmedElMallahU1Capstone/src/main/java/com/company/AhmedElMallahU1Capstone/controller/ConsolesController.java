package com.company.AhmedElMallahU1Capstone.controller;

import com.company.AhmedElMallahU1Capstone.service.ServiceLayer;
import com.company.AhmedElMallahU1Capstone.viewmodel.ConsoleViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/consoles")
public class ConsolesController {

    @Autowired
    ServiceLayer serviceLayer;

    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    ConsoleViewModel getConsole(@PathVariable int id){
        return serviceLayer.findConsole(id);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    List<ConsoleViewModel> getAllConsoles(){
        return serviceLayer.findAllConsoles();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    String deleteConsole(@PathVariable int id){
        return serviceLayer.removeConsole(id);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    ConsoleViewModel addConsole(@RequestBody @Valid ConsoleViewModel consoleViewModel){
        return serviceLayer.saveConsole(consoleViewModel);
    }

    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.CREATED)
    ConsoleViewModel updateConsole(@RequestBody @Valid ConsoleViewModel consoleViewModel, @PathVariable int id){
        if(id!=consoleViewModel.getId()){
            throw new IllegalArgumentException("Ids in path and request body don't match!");
        }
        return serviceLayer.updateConsole(consoleViewModel);
    }

    @GetMapping("/manufacturer/{manufacturer}")
    @ResponseStatus(value = HttpStatus.OK)
    List<ConsoleViewModel> getConsoleByManufacturer(@PathVariable String manufacturer){
        return serviceLayer.findConsolesByManufacturer(manufacturer);
    }
}
