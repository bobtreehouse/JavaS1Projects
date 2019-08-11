package com.company.AhmedElMallahU1Capstone.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class TShirt {

    //SQL
    //t_shirt_id int(11) not null auto_increment primary key,
    //size varchar(20) not null,
    //color varchar(20) not null,
    //description varchar(255) not null,
    //price decimal(5,2) not null,
    //quantity int(11) not null

    private int id;
    private String size;
    private String color;
    private String description;
    private BigDecimal price;
    private int quantity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TShirt tShirt = (TShirt) o;
        return getId() == tShirt.getId() &&
                getQuantity() == tShirt.getQuantity() &&
                Objects.equals(getSize(), tShirt.getSize()) &&
                Objects.equals(getColor(), tShirt.getColor()) &&
                Objects.equals(getDescription(), tShirt.getDescription()) &&
                Objects.equals(getPrice(), tShirt.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSize(), getColor(), getDescription(), getPrice(), getQuantity());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
