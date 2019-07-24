package com.trilogyed.vinlookup.ViewModel;

import javax.validation.constraints.NotEmpty;
import java.util.Objects;

public class VinLookupView {

    @NotEmpty(message = "Please supply vehicle type.")
    private String type;
    @NotEmpty(message = "Please supply vehicle type.")
    private String make;
    @NotEmpty(message = "Please supply vehicle type.")
    private String model;
    @NotEmpty(message = "Please supply vehicle type.")
    private String year;
    @NotEmpty(message = "Please supply vehicle type.")
    private String color;
    @NotEmpty(message = "Please supply vehicle type.")

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VinLookupView that = (VinLookupView) o;
        return Objects.equals(type, that.type) &&
                Objects.equals(make, that.make) &&
                Objects.equals(model, that.model) &&
                Objects.equals(year, that.year) &&
                Objects.equals(color, that.color);

    }
    @Override
    public int hashCode() {
        return Objects.hash(type, make, model, year, color);


    }
}
