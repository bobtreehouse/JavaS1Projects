package BobTriesteU1Capstone.GameStore.controller;

import BobTriesteU1Capstone.GameStore.exception.NotFoundException;
import BobTriesteU1Capstone.GameStore.service.ConsoleService;
import BobTriesteU1Capstone.GameStore.viewmodel.ConsoleViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

public class ConsoleInventoryController {


    @RestController
    @RequestMapping("/console")//This mapping at class level allows to set the base path for the Customer API
    public class CustomerInventoryController {

        @Autowired
        ConsoleService consoleService;

        @PostMapping//Another way to set the Rest API Post mapping
        @ResponseStatus(HttpStatus.CREATED)
        public ConsoleViewModel addConsole(@RequestBody @Valid ConsoleViewModel console) {
            return consoleService.saveConsole(console);
        }

        @GetMapping("/{id}")//Another way to set the Rest API Get mapping
        @ResponseStatus(HttpStatus.OK)
        public ConsoleViewModel getConsole(@PathVariable("id") int consoleId) {
            ConsoleViewModel customerViewModel = consoleService.getConsole(consoleId);
            if (customerViewModel == null)
                throw new NotFoundException("Customer could not be retrieved for id " + consoleId);
            return customerViewModel;
        }

        @DeleteMapping("/{id}")//Another way to set the Rest API Delete mapping
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void deleteConsole(@PathVariable("id") int id) {
            consoleService.removeConsole(id);
        }

        @PutMapping("/{id}")//Another way to set the Rest API Put mapping
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void updateCustomer(@PathVariable("id") int id, @RequestBody @Valid ConsoleViewModel consoleViewModel) {
            if (consoleViewModel.getConsoleId() == 0)
                consoleViewModel.setConsoleId(id);
            if (id != consoleViewModel.getConsoleId()) {
                throw new IllegalArgumentException("Customer ID on path must match the ID in the Customer object");
            }
            consoleService.updateConsole(consoleViewModel);
        }

    }
}
