package BobTriesteU1Capstone.GameStore.service;

import BobTriesteU1Capstone.GameStore.dao.ConsoleDao;
import BobTriesteU1Capstone.GameStore.dao.ConsoleJdbcTemplateImpl;
import BobTriesteU1Capstone.GameStore.model.Console;
import BobTriesteU1Capstone.GameStore.viewmodel.ConsoleViewModel;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class ConsoleServiceTest {


    ConsoleDao consoleDao;
    ConsoleService consoleService;

    @Before
    public void setUp() throws Exception {
        setUpConsoleDaoMock();
        consoleService = new ConsoleService(consoleDao);
    }



    private void setUpConsoleDaoMock() {
        consoleDao = mock(ConsoleJdbcTemplateImpl.class);

        //Request Console
        Console console0 = new Console();
        console0.setModel("Playstation");
        console0.setManufacturer("Sony");
        console0.setMemoryAmount("16GB");
        console0.setProcessor("Quad i7");
        console0.setPrice(new BigDecimal("319.99").setScale(2));
        console0.setQuantity(250);

        //Response Console
        Console console1 = new Console();
        console1.setModel("Playstation");
        console1.setManufacturer("Sony");
        console1.setMemoryAmount("16GB");
        console1.setProcessor("Quad i7");
        console1.setPrice(new BigDecimal("399.99").setScale(2));
        console1.setQuantity(250);
        console1.setConsoleId(21);

        //Updated Console
        Console console1Updated = new Console();
        console1Updated.setModel("Playstation");
        console1Updated.setManufacturer("Sony");
        console1Updated.setMemoryAmount("16GB");
        console1Updated.setProcessor("Quad i7");
        console1Updated.setPrice(new BigDecimal("349.99").setScale(2));
        console1Updated.setQuantity(250);
        console1Updated.setConsoleId(21);

        //Adding 2nd Console
        Console console2 = new Console();
        console2.setConsoleId(22);
        console2.setModel("xbox One");
        console2.setManufacturer("Microsoft");
        console2.setMemoryAmount("16GB");
        console2.setProcessor("Quad i7");
        console2.setPrice(new BigDecimal("399.99").setScale(2));
        console2.setQuantity(250);

        List<Console> consoles = new ArrayList<>();
        List<Console> consolesByManufacturer = new ArrayList<>();

        consoles.add(console1); consoles.add(console2);
        consolesByManufacturer.add(console1);

        doReturn(console1).when(consoleDao).addConsole(console0);
        doReturn(console1).when(consoleDao).getConsole(21);
        doReturn(console1Updated).when(consoleDao).updateConsole(console1Updated);
        doReturn(consoles).when(consoleDao).getAllConsoles();
        doReturn(consolesByManufacturer).when(consoleDao).getConsoleByManufacturer("Sony");
    }
    @Test
    public void removeConsole() {
    }
}