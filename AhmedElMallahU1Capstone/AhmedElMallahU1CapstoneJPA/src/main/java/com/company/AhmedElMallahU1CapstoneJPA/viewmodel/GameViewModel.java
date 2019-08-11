package com.company.AhmedElMallahU1CapstoneJPA.viewmodel;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Objects;

public class GameViewModel {
    private int id;
    @NotEmpty(message = "Title cannot be empty.")
    private String title;
    @NotEmpty(message = "ERSB Rating cannot be empty.")
    private String ersbRating;
    @NotEmpty(message = "Description cannot be empty.")
    private String description;
    @NotEmpty(message = "Studio cannot be empty.")
    private String studio;
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
        GameViewModel that = (GameViewModel) o;
        return getId() == that.getId() &&
                getQuantity() == that.getQuantity() &&
                Objects.equals(getTitle(), that.getTitle()) &&
                Objects.equals(getErsbRating(), that.getErsbRating()) &&
                Objects.equals(getDescription(), that.getDescription()) &&
                Objects.equals(getStudio(), that.getStudio()) &&
                Objects.equals(getPrice(), that.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getErsbRating(), getDescription(), getStudio(), getPrice(), getQuantity());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getErsbRating() {
        return ersbRating;
    }

    public void setErsbRating(String ersbRating) {
        this.ersbRating = ersbRating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
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
