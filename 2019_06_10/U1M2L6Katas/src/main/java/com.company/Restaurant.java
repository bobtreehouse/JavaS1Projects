package com.company;

public class Restaurant {

    private int numberRestrooms;
    private String name;
    private int smokeAlarms;
    private String foodSpecialty;
    private boolean passedInspection;

    public int getNumberRestrooms() {
        return numberRestrooms;
    }

    public void setNumberRestrooms(int numberRestrooms) {
        this.numberRestrooms = numberRestrooms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSmokeAlarms() {
        return smokeAlarms;
    }

    public void setSmokeAlarms(int smokeAlarms) {
        this.smokeAlarms = smokeAlarms;
    }

    public String getFoodSpecialty() {
        return foodSpecialty;
    }

    public void setFoodSpecialty(String foodSpecialty) {
        this.foodSpecialty = foodSpecialty;
    }

    public boolean isPassedInspection() {
        return passedInspection;
    }

    public void setPassedInspection(boolean passedInspection) {
        this.passedInspection = passedInspection;
    }
}
