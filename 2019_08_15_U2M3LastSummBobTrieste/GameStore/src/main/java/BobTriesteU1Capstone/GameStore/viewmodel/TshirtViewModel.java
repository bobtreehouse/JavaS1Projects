package BobTriesteU1Capstone.GameStore.viewmodel;

import BobTriesteU1Capstone.GameStore.model.Tshirt;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Objects;

public class TshirtViewModel {
    private int tshirtId;
    @NotEmpty(message = "Size cannot be empty.")
    private String size;
    @NotEmpty(message = "Color cannot be empty.")
    private String color;
    @NotEmpty(message = "Description cannot be empty.")
    private String description;
    @PositiveOrZero(message = "Price is not valid [positive or zero].")
    @NotNull(message = "Price cannot be null.")
    @DecimalMax(value = "999.99", message = "Maximum price allowed 999.99")
    private BigDecimal price;
    @Positive(message = "Quantity must be a positive integer.")
    private int quantity;

    public int getTshirtId() {
        return tshirtId;
    }

    public void setTshirtId(int tshirtId) {
        this.tshirtId = tshirtId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TshirtViewModel that = (TshirtViewModel) o;
        return tshirtId == that.tshirtId &&
                size == that.size &&
                color == that.color &&
                description == that.description &&
                price.equals(that.price) &&
                quantity==that.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tshirtId, size, color, description, price, quantity);
    }
}

