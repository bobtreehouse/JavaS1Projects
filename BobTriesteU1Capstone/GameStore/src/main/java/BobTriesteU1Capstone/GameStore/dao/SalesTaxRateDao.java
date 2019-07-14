package BobTriesteU1Capstone.GameStore.dao;
import BobTriesteU1Capstone.GameStore.model.SalesTaxRate;
import java.util.List;

public interface SalesTaxRateDao {




    SalesTaxRate getSalesTaxRate(int id);

    List<SalesTaxRate> getAllSalesTaxRates();

    void updateSalesTaxRate(SalesTaxRate salesTaxRate);

    void deleteSalesTaxRate(int id);


}
