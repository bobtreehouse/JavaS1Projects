package BobTriesteU1Capstone.GameStore.dao;
import BobTriesteU1Capstone.GameStore.model.Console;

import java.util.List;

public interface ConsoleDao {

    Console addConsole(Console console);

    Console getConsole(int consoleId);

    List<Console> getAllConsoles();

    Console updateConsole(Console console);

    void deleteConsole(int consoleId);

    List<Console> getConsoleByManufacturer(String string);


}
