package BobTriesteU1Capstone.GameStore.viewmodel;

import BobTriesteU1Capstone.GameStore.model.Invoice;

import java.math.BigDecimal;
import java.util.Objects;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class InvoiceViewModel {

    private int invoiceId;
    @NotEmpty(message="Please supply name")
    private String name;
    @NotEmpty(message="Please supply street")
    private String street;
    @NotEmpty(message="Please supply city")
    private String city;
    @NotEmpty(message="Please supply an state")
    private String state;
    @NotEmpty(message="Please supply zipcode")
    private String zipcode;
    @NotEmpty(message="Please supply an item type")
    private String itemType;
    @NotEmpty(message="Please supply item id")
    private int itemId;
    @NotEmpty(message="Please supply unit price")
    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "999999.99", inclusive = true)
    private BigDecimal unitPrice;
    @NotEmpty(message="Please supply quantity")
    private int quantity;
    @NotEmpty(message="Please supply unit subtotal")
    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "999999.99", inclusive = true)
    private BigDecimal subtotal;
    @NotEmpty(message="Please supply tax")
    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "999999.99", inclusive = true)
    private BigDecimal tax;
    @NotEmpty(message="Please supply processing fee")
    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "999999.99", inclusive = true)
    private BigDecimal processiongFee;
    @NotEmpty(message="Please supply total")
    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "999999.99", inclusive = true)
    private BigDecimal total;

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getProcessiongFee() {
        return processiongFee;
    }

    public void setProcessiongFee(BigDecimal processiongFee) {
        this.processiongFee = processiongFee;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceViewModel that = (InvoiceViewModel) o;
        return invoiceId == that.invoiceId &&
                street == that.street &&
                city == that.city &&
                state == that.state &&
                zipcode.equals(that.zipcode) &&
                itemType.equals(that.itemType) &&
                itemId==(that.itemId)&&
                unitPrice == that.unitPrice &&
                quantity == that.quantity &&
                subtotal == that.subtotal &&
                tax.equals(that.tax) &&
                processiongFee.equals(that.processiongFee) &&
                total.equals(that.total);


    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceId, street, city, state, zipcode, itemType, itemId, unitPrice, quantity, subtotal, tax, processiongFee, total);
    }
}