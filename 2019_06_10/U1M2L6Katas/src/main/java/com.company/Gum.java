package com.company;

public class Gum {

    private String name;
    private int piecesPerPack;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPiecesPerPack() {
        return piecesPerPack;
    }

    public void setPiecesPerPack(int piecesPerPack) {
        this.piecesPerPack = piecesPerPack;
    }

    public boolean isHasSugar() {
        return hasSugar;
    }

    public void setHasSugar(boolean hasSugar) {
        this.hasSugar = hasSugar;
    }

    public int getNumCalories() {
        return numCalories;
    }

    public void setNumCalories(int numCalories) {
        this.numCalories = numCalories;
    }

    boolean hasSugar;
    private int numCalories;

}
