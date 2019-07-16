package BobTriesteU1Capstone.GameStore.viewmodel;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import BobTriesteU1Capstone.GameStore.model.Game;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.Objects;

public class GameViewModel {


    private int gameId;
    @NotEmpty(message = "Please supply title")
    private String title;
    @NotEmpty(message = "Please supply  esrb_rating")
    private String esrb_rating;
    @NotEmpty(message = "Please supply description")
    private String description;
    @NotEmpty(message = "Please supply a value for price")
    private BigDecimal price;
    @NotEmpty(message = "Please supply studio")
    private String studio;
    @NotEmpty(message = "Please supply a value for quantity")
    private int quantity;

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEsrb_rating() {
        return esrb_rating;
    }

    public void setEsrb_rating(String esrb_rating) {
        this.esrb_rating = esrb_rating;
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

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
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
        GameViewModel that = (GameViewModel) o;
        return gameId == that.gameId &&
                title == that.title &&
                esrb_rating == that.esrb_rating &&
                description == that.description &&
                price.equals(that.price) &&
                studio.equals(that.studio) &&
                quantity==(that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId, title, esrb_rating, description, price, studio, quantity);
    }
}
