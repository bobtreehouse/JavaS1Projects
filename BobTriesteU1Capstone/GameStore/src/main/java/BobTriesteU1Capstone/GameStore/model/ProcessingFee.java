package BobTriesteU1Capstone.GameStore.model;

import java.math.BigDecimal;
import java.util.Objects;

public class ProcessingFee {

    private BigDecimal rate;
    private String state;
    private String productType;
    private BigDecimal fee;

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProcessingFee that = (ProcessingFee) o;
        return productType == that.productType &&

                fee.equals(that.fee);


    }

    @Override
    public int hashCode() {
        return Objects.hash(productType, fee);
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
