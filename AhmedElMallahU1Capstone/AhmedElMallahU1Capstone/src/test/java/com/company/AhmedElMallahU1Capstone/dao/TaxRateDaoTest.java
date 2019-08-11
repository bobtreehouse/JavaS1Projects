package com.company.AhmedElMallahU1Capstone.dao;

import com.company.AhmedElMallahU1Capstone.dto.ProcessingFee;
import com.company.AhmedElMallahU1Capstone.dto.TaxRate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TaxRateDaoTest {

    @Autowired
    private TaxRateDao taxRateDao;

    @Test
    public void getByState() {
        TaxRate taxRate = new TaxRate();
        taxRate.setState("NJ");
        taxRate.setRate(new BigDecimal("0.05").setScale(2));

        TaxRate fromDB = taxRateDao.getByState("NJ");

        assertEquals(fromDB, taxRate);
    }
}