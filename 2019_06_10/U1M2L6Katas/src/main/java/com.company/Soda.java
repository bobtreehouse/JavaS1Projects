package com.company;

public class Soda {

    String brand;
    boolean isDiet;
    int calories;
    String flavor;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public boolean isDiet() {
        return isDiet;
    }

    public void setDiet(boolean diet) {
        isDiet = diet;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public int getSizeOunces() {
        return sizeOunces;
    }

    public void setSizeOunces(int sizeOunces) {
        this.sizeOunces = sizeOunces;
    }

    int sizeOunces;

}
