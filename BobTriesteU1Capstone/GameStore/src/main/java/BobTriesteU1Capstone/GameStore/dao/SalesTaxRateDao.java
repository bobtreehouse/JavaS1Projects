package BobTriesteU1Capstone.GameStore.dao;
import BobTriesteU1Capstone.GameStore.model.SalesTaxRate;

import java.math.BigDecimal;
import java.util.List;

public interface SalesTaxRateDao {



    SalesTaxRate getSalesTaxRate(String state);


    List<SalesTaxRate> getAllSalesTaxRates();


}
