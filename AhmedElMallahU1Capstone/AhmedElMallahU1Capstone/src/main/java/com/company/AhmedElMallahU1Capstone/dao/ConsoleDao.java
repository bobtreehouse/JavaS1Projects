package com.company.AhmedElMallahU1Capstone.dao;

import com.company.AhmedElMallahU1Capstone.dto.Console;

import java.util.List;

public interface ConsoleDao {

    //CRUD Methods
    Console addConsole(Console console);
    Console getConsole(int id);
    List<Console> getAllConsoles();
    Console updateConsole(Console console);
    void deleteConsole(int id);

    //Custom Methods
    List<Console> getConsoleByManufacturer(String manufacturer);
}
