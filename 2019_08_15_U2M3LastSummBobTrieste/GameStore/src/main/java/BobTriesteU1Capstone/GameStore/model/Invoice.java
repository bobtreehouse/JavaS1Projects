package BobTriesteU1Capstone.GameStore.model;

import BobTriesteU1Capstone.GameStore.viewmodel.ConsoleViewModel;

import java.math.BigDecimal;
import java.util.Objects;

public class Invoice extends ConsoleViewModel {

    private int invoiceId;
    private String name;
    private String street;
    private String city;
    private String state;
    private String zipcode;
    private String itemType;
    private int itemId;
    private BigDecimal unitPrice;
    private int quantity;
    private BigDecimal subtotal;
    private BigDecimal tax;
    private BigDecimal processiongFee;
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
        Invoice that = (Invoice) o;
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
