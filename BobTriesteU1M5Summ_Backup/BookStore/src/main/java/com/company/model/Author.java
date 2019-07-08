package com.company.model;



import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;



public class Author {


    private int author_id;
    private String first_name;
    private String last_name;
    private String street;
    private String city;
    private char state;
    private String postal_code;
    private String phone;
    private String  email;

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public char getState() {
        return state;
    }

    public void setState(char state) {
        this.state = state;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author that = (Author) o;
        return getAuthor_id() == that.getAuthor_id() &&
                Objects.equals(getFirst_name(), that.getFirst_name()) &&
                Objects.equals(getLast_name(), that.getLast_name()) &&
                Objects.equals(getStreet(), that.getStreet()) &&
                Objects.equals(getCity(), that.getCity()) &&
                Objects.equals(getState(), that.getState()) &&
                Objects.equals(getPostal_code(), that.getPostal_code()) &&
                Objects.equals(getPhone(), that.getPhone()) &&
                Objects.equals(getEmail(), that.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAuthor_id(), getFirst_name(), getLast_name(), getStreet(), getCity(), getPostal_code(), getPhone(), getEmail());
    }

    public void getFirst_name(String first_name) {
    }
    public void getLast_name(String last_name) {
    }
    public void getStreet(String street) {
    }
    public void getCity(String city) {
    }
    public void getState(String state) {
    }
    public void getPhone(String phone) {
    }
    public void getEmail(String email) {
    }
    public void getPostal_code(String postal_code) {
    }
    public void getAuthor_id(int author_id) {
    }

    public void setState(String state) {
    }
}
