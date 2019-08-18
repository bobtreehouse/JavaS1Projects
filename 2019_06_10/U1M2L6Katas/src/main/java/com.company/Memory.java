package com.company;

public class Memory {

    private int busSpeed;
    private String manufacturer;
    private String modelName;
    private boolean isMulticore;

    public int getBusSpeed() {
        return busSpeed;
    }

    public void setBusSpeed(int busSpeed) {
        this.busSpeed = busSpeed;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public boolean isMulticore() {
        return isMulticore;
    }

    public void setMulticore(boolean multicore) {
        isMulticore = multicore;
    }
}
