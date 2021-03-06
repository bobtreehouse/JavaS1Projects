package com.RentalStore.RentalStore.model;



import java.math.BigDecimal;
import java.util.Objects;

public class Item {

    private int id;
    private String name;
    private String description;
    private BigDecimal dailyRate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(BigDecimal dailyRate) {
        this.dailyRate = dailyRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item ) o;
        return getId() == item.getId() &&
                Objects.equals(getName(), item.getName()) &&
                Objects.equals(getDescription(), item.getDescription())  &&
                Objects.equals(getDailyRate(), item.getDailyRate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDescription(), getDailyRate());
    }


}