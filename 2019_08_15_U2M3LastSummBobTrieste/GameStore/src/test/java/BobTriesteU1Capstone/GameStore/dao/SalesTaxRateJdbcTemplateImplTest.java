package BobTriesteU1Capstone.GameStore.dao;

import BobTriesteU1Capstone.GameStore.model.*;
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
public class SalesTaxRateJdbcTemplateImplTest {


    @Autowired
    SalesTaxRateDao salesTaxRateDao;



    @Test
    public void getSalesTaxRate() {

        SalesTaxRate salesTaxRate = salesTaxRateDao.getSalesTaxRate("NJ");


        SalesTaxRate salesTaxRateNJ = new SalesTaxRate();
        salesTaxRateNJ.setState("NJ");
        salesTaxRateNJ.setRate(new BigDecimal(".05"));

        assertEquals(salesTaxRateNJ.getRate(), salesTaxRate.getRate());

        }


    }