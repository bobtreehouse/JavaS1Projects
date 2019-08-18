package com.company;

public class Chips {

    String brand;
    int calories;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public boolean isAreGlutenFree() {
        return areGlutenFree;
    }

    public void setAreGlutenFree(boolean areGlutenFree) {
        this.areGlutenFree = areGlutenFree;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    boolean areGlutenFree;
    String flavor;

}
