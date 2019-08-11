package com.company.AhmedElMallahU1Capstone.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class Game {

    //SQL
    //game_id int(11) not null auto_increment primary key,
    //title varchar(50) not null,
    //ersb_rating varchar(50) not null,
    //description varchar(255) not null,
    //price decimal(5, 2) not null,
    //studio varchar(50) not null,
    //quantity int(11) not null

    private int id;
    private String title;
    private String ersbRating;
    private String description;
    private String studio;
    private BigDecimal price;
    private int quantity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return getId() == game.getId() &&
                getQuantity() == game.getQuantity() &&
                Objects.equals(getTitle(), game.getTitle()) &&
                Objects.equals(getErsbRating(), game.getErsbRating()) &&
                Objects.equals(getDescription(), game.getDescription()) &&
                Objects.equals(getStudio(), game.getStudio()) &&
                Objects.equals(getPrice(), game.getPrice());
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
