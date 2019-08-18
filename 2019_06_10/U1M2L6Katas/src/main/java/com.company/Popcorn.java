package com.company;

public class Popcorn {

    private String name;
    private int numCalories;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumCalories() {
        return numCalories;
    }

    public void setNumCalories(int numCalories) {
        this.numCalories = numCalories;
    }

    public boolean isGlutenFree() {
        return isGlutenFree;
    }

    public void setGlutenFree(boolean glutenFree) {
        isGlutenFree = glutenFree;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private boolean isGlutenFree;
    private int size;

}
