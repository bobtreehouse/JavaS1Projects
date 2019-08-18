package com.company;

public class Processor {

    private int clockSpeed;
    private String manufacturer;
    private String modelName;
    private boolean isMulticore;

    public int getClockSpeed() {
        return clockSpeed;
    }

    public void setClockSpeed(int clockSpeed) {
        this.clockSpeed = clockSpeed;
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
