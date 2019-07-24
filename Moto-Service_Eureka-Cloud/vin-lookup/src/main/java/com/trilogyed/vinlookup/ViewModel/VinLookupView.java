package com.trilogyed.vinlookup.ViewModel;

import javax.validation.constraints.NotEmpty;
import java.util.Objects;

public class VinLookupView {

    @NotEmpty(message = "Please supply vehicle type.")
    private String type;
    @NotEmpty(message = "Please supply vehicle vin.")
    private String vin;
    @NotEmpty(message = "Please supply vehicle make.")
    private String make;
    @NotEmpty(message = "Please supply vehicle model.")
    private String model;
    @NotEmpty(message = "Please supply vehicle year.")
    private String year;
    @NotEmpty(message = "Please supply vehicle color.")
    private String color;
    @NotEmpty(message = "Please supply vehicle VIN.")
    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }



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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VinLookupView that = (VinLookupView) o;
        return Objects.equals(getType(), that.getType()) &&
                Objects.equals(getVin(), that.getVin()) &&
                Objects.equals(getMake(), that.getMake()) &&
                Objects.equals(getModel(), that.getModel()) &&
                Objects.equals(getYear(), that.getYear()) &&
                Objects.equals(getColor(), that.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getVin(), getMake(), getModel(), getYear(), getColor());
    }
}
