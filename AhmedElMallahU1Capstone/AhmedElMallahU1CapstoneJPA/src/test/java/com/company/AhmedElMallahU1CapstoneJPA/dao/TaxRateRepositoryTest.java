package com.company.AhmedElMallahU1CapstoneJPA.dao;

import com.company.AhmedElMallahU1CapstoneJPA.dto.TaxRate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaxRateRepositoryTest {

    @Autowired
    TaxRateRepository taxRateRepository;

    @Test
    public void getByState() {
        TaxRate taxRate = new TaxRate();
        taxRate.setState("NJ");
        taxRate.setRate(new BigDecimal("0.05").setScale(2));

        TaxRate fromDB = taxRateRepository.findByState("NJ");

        assertEquals(fromDB, taxRate);
    }

}