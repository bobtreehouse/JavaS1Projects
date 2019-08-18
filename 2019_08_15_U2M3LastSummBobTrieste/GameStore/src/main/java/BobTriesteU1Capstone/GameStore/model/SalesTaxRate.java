package BobTriesteU1Capstone.GameStore.model;

import java.math.BigDecimal;
import java.util.Objects;

public class SalesTaxRate {

    private String state;
    private BigDecimal rate;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalesTaxRate salesTaxRate = (SalesTaxRate) o;
        return state == salesTaxRate.state &&
                rate.equals(salesTaxRate.rate);

    }

    @Override
    public int hashCode() {
        return Objects.hash(state, rate);
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

}
