package com.company;

public class OpticalDrive {

    String manufacturer;
    String modelName;

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

    public boolean isHasOptical() {
        return hasOptical;
    }

    public void setHasOptical(boolean hasOptical) {
        this.hasOptical = hasOptical;
    }

    public int getSpeedRPM() {
        return speedRPM;
    }

    public void setSpeedRPM(int speedRPM) {
        this.speedRPM = speedRPM;
    }

    boolean hasOptical;
    int speedRPM;


}
