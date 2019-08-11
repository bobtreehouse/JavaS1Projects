package com.company.AhmedElMallahU1CapstoneJPA.dao;

import com.company.AhmedElMallahU1CapstoneJPA.dto.TShirt;
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

public class TShirtRepositoryTest {

    @Autowired
    TShirtRepository tShirtRepository;

    @Before
    public void setUp() throws Exception {
        tShirtRepository.deleteAll();
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
        TShirt addDaoTShirt = tShirtRepository.save(tShirt);

        //Get Dao
        TShirt getDaoTshirt = tShirtRepository.findById(addDaoTShirt.getId()).get();

        assertEquals(addDaoTShirt,getDaoTshirt);

        //Delete Dao
        tShirtRepository.deleteById(getDaoTshirt.getId());

        try {
            getDaoTshirt = tShirtRepository.findById(getDaoTshirt.getId()).get();
        } catch (NoSuchElementException e){
            getDaoTshirt = null;
        }


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
        tShirt = tShirtRepository.save(tShirt);

        //Changing Color
        tShirt.setColor("Orange");

        //Update Dao
        TShirt updateDaoTShirt = tShirtRepository.save(tShirt);

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
        tShirt = tShirtRepository.save(tShirt);

        //Adding 2nd T-Shirt
        TShirt tShirt2 = new TShirt();
        tShirt2.setColor("Green");
        tShirt2.setSize("M");
        tShirt2.setDescription("Medium Green T-Shirt");
        tShirt2.setPrice(new BigDecimal("24.99").setScale(2));
        tShirt2.setQuantity(250);
        tShirt2 = tShirtRepository.save(tShirt2);

        //GetAll
        List<TShirt> allTShirts = tShirtRepository.findAll();
        //GetByColor
        List<TShirt> redTShirts = tShirtRepository.findByColor("Red");
        //GetBySize
        List<TShirt> largeTShirts = tShirtRepository.findBySize("L");

        //Asserts
        assertEquals(allTShirts.size(),2);
        assertEquals(redTShirts.size(),1);
        assertEquals(largeTShirts.size(),1);
    }
}