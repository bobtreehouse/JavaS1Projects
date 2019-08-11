package com.company.AhmedElMallahU1Capstone.dao;

import com.company.AhmedElMallahU1Capstone.dto.TaxRate;

public interface TaxRateDao {
    TaxRate getByState(String state);
}
