package com.company;



import com.company.Televisions;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Televisions {

    private String brand;
    private String model;
    private int price;
    private int screenSize;

    public Televisions(String brand, String model, int price, int screenSize) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.screenSize = screenSize;
    }




    public Televisions () {

    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }



}


