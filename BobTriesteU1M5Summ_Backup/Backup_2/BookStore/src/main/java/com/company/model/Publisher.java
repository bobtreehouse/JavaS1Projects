package com.company.model;


import java.util.Objects;



public class Publisher {

    private int publisher_id;
    private String name;
    private String street2;
    private String city2;
    private char state2;
    private String postal_code2;
    private String phone2;
    private String email2;

    public String getStreet2() {
        return street2;
    }

    public int getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(int publisher_id) {
        this.publisher_id = publisher_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet2(String street) {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity2() {
        return city2;
    }

    public void setCity2(String city2) {
        this.city2 = city2;
    }

    public char getState2() {
        return state2;
    }

    public void setState2(char state2) {
        this.state2 = state2;
    }

    public String getPostal_code2() {
        return postal_code2;
    }

    public void setPostal_code2(String postal_code2) {
        this.postal_code2 = postal_code2;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public void getName(String name) {
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher that = (Publisher) o;
        return getPublisher_id() == that.getPublisher_id() &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getStreet2(), that.getStreet2()) &&
                Objects.equals(getCity2(), that.getCity2()) &&
                Objects.equals(getState2(), that.getState2()) &&
                Objects.equals(getPostal_code2(), that.getPostal_code2()) &&
                Objects.equals(getPhone2(), that.getPhone2()) &&
                Objects.equals(getEmail2(), that.getEmail2());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPublisher_id(), getName(), getStreet2(), getCity2(), getState2(), getPostal_code2(), getPhone2(), getEmail2());
    }


    public void getCity2(String city) {
    }

    public void getPhone2(String phone) {
    }

    public void getEmail2(String email) {
    }

    public void getState2(String state) {
    }

    public void getPostal_code2(String postal_code) {
    }

    public void setState2(String nj) {
    }
}
