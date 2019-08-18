package BobTriesteU1Capstone.GameStore.service;

import BobTriesteU1Capstone.GameStore.dao.ConsoleDao;
import BobTriesteU1Capstone.GameStore.dao.TshirtDao;
import BobTriesteU1Capstone.GameStore.dao.TshirtJdbcTemplateImpl;
import BobTriesteU1Capstone.GameStore.model.Tshirt;
import BobTriesteU1Capstone.GameStore.viewmodel.TshirtViewModel;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class TshirtServiceTest {

    TshirtDao tshirtDao;
    TshirtService tshirtService;

    @Before
    public void setUp() throws Exception {
        setUpTShirtDaoMock();
        tshirtService = new TshirtService(tshirtDao);
    }

    @Test
    public void saveFindUpdateTShirt() {
        TshirtViewModel tvm = new TshirtViewModel();
        tvm.setColor("Blue");
        tvm.setSize("M");
        tvm.setDescription("Med Blue T-Shirt");
        tvm.setPrice(new BigDecimal("29.99").setScale(2));
        tvm.setQuantity(350);

        //Add
        tvm = tshirtService.saveTshirt(tvm);

        //Find
        TshirtViewModel TShirtFromService = tshirtService.findTShirt(tvm.getTshirtId());

        assertEquals(tvm, TShirtFromService);

        //Update
        tvm.setColor("Blue");
        TshirtViewModel updatedTShirtFromService = tshirtService.updateTshirt(tvm);

        assertEquals(tvm, updatedTShirtFromService);
    }

    @Test
    public void findAllTShirtsAndByColorAndSize() {
        List<TshirtViewModel> tShirts = tshirtService.findAllTShirts();

        assertEquals(tShirts.size(), 2);

        tShirts = tshirtService.findTShirtsByColor("Blue");

        assertEquals(tShirts.size(), 2);

        tShirts = tshirtService.findTShirtsBySize("M");

        assertEquals(tShirts.size(), 2);
    }


    private void setUpTShirtDaoMock() {
        tshirtDao = mock(TshirtJdbcTemplateImpl.class);

        Tshirt tShirt0 = new Tshirt();
        tShirt0.setColor("Blue");
        tShirt0.setSize("M");
        tShirt0.setDescription("Med Blue T-Shirt");
        tShirt0.setPrice(new BigDecimal("29.99").setScale(2));
        tShirt0.setQuantity(350);

        // Reply
        Tshirt tShirt1 = new Tshirt();
        tShirt1.setTshirtId(12);
        tShirt1.setColor("Blue");
        tShirt1.setSize("M");
        tShirt1.setDescription("Med Blue T-Shirt");
        tShirt1.setPrice(new BigDecimal("29.99").setScale(2));
        tShirt1.setQuantity(350);

        // Updated
        Tshirt tShirt1Updated =  new Tshirt();
        tShirt1Updated.setTshirtId(12);
        tShirt1Updated.setColor("Red");
        tShirt1Updated.setSize("L");
        tShirt1Updated.setDescription("Large Red T-Shirt");
        tShirt1Updated.setPrice(new BigDecimal("29.99").setScale(2));
        tShirt1Updated.setQuantity(350);

        // Additional
        Tshirt tShirt2 = new Tshirt();
        tShirt2.setTshirtId(32);
        tShirt2.setColor("Green");
        tShirt2.setSize("M");
        tShirt2.setDescription("Medium Green T-Shirt");
        tShirt2.setPrice(new BigDecimal("24.99").setScale(2));
        tShirt2.setQuantity(250);

        List<Tshirt> tShirts = new ArrayList<>();
        List<Tshirt> tShirtsByColor = new ArrayList<>();
        List<Tshirt> tShirtsBySize = new ArrayList<>();

        tShirts.add(tShirt1); tShirts.add(tShirt2);
        tShirtsByColor.add(tShirt1);
        tShirtsBySize.add(tShirt2);

        doReturn(tShirt1).when(tshirtDao).addTshirt(tShirt0);
        doReturn(tShirt1).when(tshirtDao).getTshirt(31);
        doReturn(tShirt1Updated).when(tshirtDao).updateTshirt(tShirt1Updated);
        doReturn(tShirts).when(tshirtDao).getAllTshirts();
        doReturn(tShirtsByColor).when(tshirtDao).getTShirtByColor("Blue");
        doReturn(tShirtsByColor).when(tshirtDao).getTshirtBySize("M");
    }
}