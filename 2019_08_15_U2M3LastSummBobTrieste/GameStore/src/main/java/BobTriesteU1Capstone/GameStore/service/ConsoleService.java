package BobTriesteU1Capstone.GameStore.service;

import BobTriesteU1Capstone.GameStore.dao.*;
import BobTriesteU1Capstone.GameStore.model.*;
import BobTriesteU1Capstone.GameStore.viewmodel.*;

import java.util.ArrayList;
import java.util.List;
import BobTriesteU1Capstone.GameStore.dao.TshirtDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component

public class ConsoleService {

    ConsoleDao consoleDao;

    @Autowired
    public ConsoleService(ConsoleDao consoleDao) {
        this.consoleDao = consoleDao;


    }

    public ConsoleViewModel saveConsole(ConsoleViewModel consoleViewModel) {
        Console console = new Console();
        console.setModel(consoleViewModel.getModel());
        console.setManufacturer(consoleViewModel.getManufacturer());
        console.setMemoryAmount(consoleViewModel.getMemoryAmount());
        console.setProcessor(consoleViewModel.getProcessor());
        console.setPrice(consoleViewModel.getPrice());
        console.setQuantity(consoleViewModel.getQuantity());
        console = consoleDao.addConsole(console);

        consoleViewModel.setConsoleId(console.getConsoleId());
        return consoleViewModel;
    }


    public void updateConsole(ConsoleViewModel consoleViewModel) {
        Console console = new Console();
        console.setModel(consoleViewModel.getModel());
        console.setManufacturer(consoleViewModel.getManufacturer());
        console.setMemoryAmount(consoleViewModel.getMemoryAmount());
        console.setProcessor(consoleViewModel.getProcessor());
        console.setPrice(consoleViewModel.getPrice());
        console.setQuantity(consoleViewModel.getQuantity());

        consoleDao.updateConsole(console);
    }


    private ConsoleViewModel buildConsoleViewModel(Console console) {
        ConsoleViewModel consoleViewModel = new ConsoleViewModel();
        consoleViewModel.setConsoleId(console.getConsoleId());
        consoleViewModel.setModel(console.getModel());
        consoleViewModel.setManufacturer(console.getManufacturer());
        consoleViewModel.setMemoryAmount(console.getMemoryAmount());
        consoleViewModel.setProcessor(console.getProcessor());
        consoleViewModel.setPrice(console.getPrice());
        consoleViewModel.setQuantity(console.getQuantity());
        return consoleViewModel;
    }

    public ConsoleViewModel getConsole(int id) {
        Console console = consoleDao.getConsole(id);
        if (console == null)
            return null;
        else
            return buildConsoleViewModel(console);
    }

    public void removeConsole(int id) {
        consoleDao.deleteConsole(id);
    }
}