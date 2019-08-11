package com.company.AhmedElMallahU1CapstoneJPA.dao;

import com.company.AhmedElMallahU1CapstoneJPA.dto.Console;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsoleRepositoryTest {

    @Autowired
    ConsoleRepository consoleRepository;

    @Before
    public void setUp() throws Exception {
        consoleRepository.deleteAll();
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
        Console addDaoConsole = consoleRepository.save(console);

        //Get Dao
        Console getDaoConsole = consoleRepository.findById(addDaoConsole.getId()).get();

        assertEquals(addDaoConsole, getDaoConsole);

        //Delete Dao
        consoleRepository.deleteById(getDaoConsole.getId());

        try {
            getDaoConsole = consoleRepository.findById(getDaoConsole.getId()).get();
        } catch (NoSuchElementException e){
            getDaoConsole = null;
        }


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
        console = consoleRepository.save(console);

        //Changing Model
        console.setModel("PS4 Lite");

        //Update Dao
        Console updateDaoConsole = consoleRepository.save(console);

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

        console = consoleRepository.save(console);

        //Adding 2nd Console
        Console console2 = new Console();
        console2.setModel("xbox One");
        console2.setManufacturer("Microsoft");
        console2.setMemoryAmount("16GB");
        console2.setProcessor("Quad core i-678");
        console2.setPrice(new BigDecimal("399.99").setScale(2));
        console2.setQuantity(250);

        console2 = consoleRepository.save(console2);

        //GetAll
        List<Console> allConsoles = consoleRepository.findAll();

        //GetByManufacturer
        List<Console> consolesBySony = consoleRepository.findByManufacturer("Sony");

        //Asserts
        assertEquals(allConsoles.size(),2);
        assertEquals(consolesBySony.size(), 1);
    }
}