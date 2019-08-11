package com.company.AhmedElMallahU1Capstone.dao;

import com.company.AhmedElMallahU1Capstone.dto.Console;
import com.company.AhmedElMallahU1Capstone.dto.TShirt;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TShirtDaoTest {

    @Autowired
    private TShirtDao tShirtDao;

    @Before
    public void setUp() throws Exception {
        //Cleaning Test DB
        List<TShirt> tShirts = tShirtDao.getAllTShirts();
        tShirts.stream().forEach(tShirt -> tShirtDao.deleteTShirt(tShirt.getId()));
    }

    @Test
    public void addGetDeleteTShirt() {
        //Adding T-Shirt
        TShirt tShirt = new TShirt();
        tShirt.setColor("Red");
        tShirt.setSize("L");
        tShirt.setDescription("Larger Red T-Shirt");
        tShirt.setPrice(new BigDecimal("29.99").setScale(2));
        tShirt.setQuantity(350);

        //Add Dao
        TShirt addDaoTShirt = tShirtDao.addTShirt(tShirt);

        //Get Dao
        TShirt getDaoTshirt = tShirtDao.getTShirt(addDaoTShirt.getId());

        assertEquals(addDaoTShirt,getDaoTshirt);

        //Delete Dao
        tShirtDao.deleteTShirt(getDaoTshirt.getId());

        getDaoTshirt = tShirtDao.getTShirt(getDaoTshirt.getId());

        assertNull(getDaoTshirt);
    }


    @Test
    public void updateTShirt() {
        //Adding T-Shirt
        TShirt tShirt = new TShirt();
        tShirt.setColor("Red");
        tShirt.setSize("L");
        tShirt.setDescription("Larger Red T-Shirt");
        tShirt.setPrice(new BigDecimal("29.99").setScale(2));
        tShirt.setQuantity(350);
        tShirt = tShirtDao.addTShirt(tShirt);

        //Changing Color
        tShirt.setColor("Orange");

        //Update Dao
        TShirt updateDaoTShirt = tShirtDao.updateTShirt(tShirt);

        assertEquals(tShirt,updateDaoTShirt);
    }

    @Test
    public void getAllTShirtsAndByColorAndBySize() {
        //Adding T-Shirt
        TShirt tShirt = new TShirt();
        tShirt.setColor("Red");
        tShirt.setSize("L");
        tShirt.setDescription("Larger Red T-Shirt");
        tShirt.setPrice(new BigDecimal("29.99").setScale(2));
        tShirt.setQuantity(350);
        tShirt = tShirtDao.addTShirt(tShirt);

        //Adding 2nd T-Shirt
        TShirt tShirt2 = new TShirt();
        tShirt2.setColor("Green");
        tShirt2.setSize("M");
        tShirt2.setDescription("Medium Green T-Shirt");
        tShirt2.setPrice(new BigDecimal("24.99").setScale(2));
        tShirt2.setQuantity(250);
        tShirt2 = tShirtDao.addTShirt(tShirt2);

        //GetAll
        List<TShirt> allTShirts = tShirtDao.getAllTShirts();
        //GetByColor
        List<TShirt> redTShirts = tShirtDao.getTShirtByColor("Red");
        //GetBySize
        List<TShirt> largeTShirts = tShirtDao.getTShirtBySize("L");

        //Asserts
        assertEquals(allTShirts.size(),2);
        assertEquals(redTShirts.size(),1);
        assertEquals(largeTShirts.size(),1);
    }
}