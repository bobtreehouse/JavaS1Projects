package com.company.AhmedElMallahU1Capstone.dao;

import com.company.AhmedElMallahU1Capstone.dto.Console;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ConsoleDaoTest {

    @Autowired
    private ConsoleDao consoleDao;

    @Before
    public void setUp() throws Exception {
        //Cleaning Test DB
        List<Console> consoles = consoleDao.getAllConsoles();
        consoles.stream().forEach(console -> consoleDao.deleteConsole(console.getId()));
    }

    @Test
    public void addGetConsole() {
        //Adding Console
        Console console = new Console();
        console.setModel("PS4 Pro");
        console.setManufacturer("Sony");
        console.setMemoryAmount("16GB");
        console.setProcessor("Quad core i-678");
        console.setPrice(new BigDecimal("399.99").setScale(2));
        console.setQuantity(250);

        //Add Dao
        Console addDaoConsole = consoleDao.addConsole(console);

        //Get Dao
        Console getDaoConsole = consoleDao.getConsole(addDaoConsole.getId());

        assertEquals(addDaoConsole, getDaoConsole);

        //Delete Dao
        consoleDao.deleteConsole(getDaoConsole.getId());

        getDaoConsole = consoleDao.getConsole(getDaoConsole.getId());

        assertNull(getDaoConsole);
    }

    @Test
    public void updateConsole() {
        //Adding Console
        Console console = new Console();
        console.setModel("PS4 Pro");
        console.setManufacturer("Sony");
        console.setMemoryAmount("16GB");
        console.setProcessor("Quad core i-678");
        console.setPrice(new BigDecimal("399.99").setScale(2));
        console.setQuantity(250);
        console = consoleDao.addConsole(console);

        //Changing Model
        console.setModel("PS4 Lite");

        //Update Dao
        Console updateDaoConsole = consoleDao.updateConsole(console);

        assertEquals(console,updateDaoConsole);
    }

    @Test
    public void getConsoleByManufacturerAndGetAll() {
        //Adding Console
        Console console = new Console();
        console.setModel("PS4 Pro");
        console.setManufacturer("Sony");
        console.setMemoryAmount("16GB");
        console.setProcessor("Quad core i-678");
        console.setPrice(new BigDecimal("399.99").setScale(2));
        console.setQuantity(250);

        console = consoleDao.addConsole(console);

        //Adding 2nd Console
        Console console2 = new Console();
        console2.setModel("xbox One");
        console2.setManufacturer("Microsoft");
        console2.setMemoryAmount("16GB");
        console2.setProcessor("Quad core i-678");
        console2.setPrice(new BigDecimal("399.99").setScale(2));
        console2.setQuantity(250);

        console2 = consoleDao.addConsole(console2);

        //GetAll
        List<Console> allConsoles = consoleDao.getAllConsoles();

        //GetByManufacturer
        List<Console> consolesBySony = consoleDao.getConsoleByManufacturer("Sony");

        //Asserts
        assertEquals(allConsoles.size(),2);
        assertEquals(consolesBySony.size(), 1);
    }
}