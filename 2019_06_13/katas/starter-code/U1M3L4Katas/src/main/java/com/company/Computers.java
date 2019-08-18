package com.company;

import com.opencsv.bean.CsvBindByName;

public class Computers {


    @CsvBindByName(column = "Brand")
    public int brand;
    @CsvBindByName(column = "Model")
    public String model;
    @CsvBindByName(column = "CPU")
    public String cPU;
    @CsvBindByName(column = "RAM")
    public String rAM;
    @CsvBindByName(column = "StorageSize")
    public String storageSize;


    public Computers(int brand, String model, String cPU, String rAM, String storageSize) {
        this.brand = brand;
        this.model = model;
        this.cPU = cPU;
        this.rAM = rAM;
        this.storageSize = storageSize;
    }

    public int getBrand() {
        return brand;
    }

    public void setBrand(int brand) {
        this.brand = brand;
    }

    public String getcPU() {
        return cPU;
    }

    public void setcPU(String cPU) {
        this.cPU = cPU;
    }

    public String getrAM() {
        return rAM;
    }

    public void setrAM(String rAM) {
        this.rAM = rAM;
    }

    public String getStorageSize() {
        return storageSize;
    }

    public void setStorageSize(String storageSize) {
        this.storageSize = storageSize;
    }

    public String getmodel() {
        return model;
    }

    public void setmodel(String storageSize) {
        this.model = model;
    }
}






