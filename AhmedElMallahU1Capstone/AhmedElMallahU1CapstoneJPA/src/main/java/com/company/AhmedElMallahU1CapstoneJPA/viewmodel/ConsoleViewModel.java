package com.company.AhmedElMallahU1CapstoneJPA.viewmodel;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Objects;

public class ConsoleViewModel {

    private int id;
    @NotEmpty(message = "Model cannot be empty.")
    private String model;
    @NotEmpty(message = "Manufacturer cannot be empty.")
    private String manufacturer;
    private String memoryAmount;
    private String processor;
    @PositiveOrZero(message = "Price is not valid [positive or zero].")
    @NotNull(message = "Price cannot be null.")
    @DecimalMax(value = "999.99", message = "Maximum price allowed 999.99")
    private BigDecimal price;
    @Positive(message = "Quantity must be a positive integer.")
    private int quantity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConsoleViewModel that = (ConsoleViewModel) o;
        return getId() == that.getId() &&
                getQuantity() == that.getQuantity() &&
                Objects.equals(getModel(), that.getModel()) &&
                Objects.equals(getManufacturer(), that.getManufacturer()) &&
                Objects.equals(getMemoryAmount(), that.getMemoryAmount()) &&
                Objects.equals(getProcessor(), that.getProcessor()) &&
                Objects.equals(getPrice(), that.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getModel(), getManufacturer(), getMemoryAmount(), getProcessor(), getPrice(), getQuantity());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getMemoryAmount() {
        return memoryAmount;
    }

    public void setMemoryAmount(String memoryAmount) {
        this.memoryAmount = memoryAmount;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
