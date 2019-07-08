package com.company.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

public class Book {


    private int book_id;
    private int isbn;
    private LocalDate publish_date;
    private int author_id;
    private String title;
    private int publisher_id;
    private double price;

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public LocalDate getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(LocalDate publish_date) {
        this.publish_date = publish_date;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(int publisher_id) {
        this.publisher_id = publisher_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public void getAuthor_id(int author_id) {
    }

    public void getTitle(String title) {
    }

    public void getBook_id(int book_id) {
    }

    public void getIsbn(int isbn) {
    }
    public void getPublish_date(Date publish_date) {
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book that = (Book) o;
        return getBook_id() == that.getBook_id() &&
                Objects.equals(getTitle(), that.getTitle()) &&
                Objects.equals(getAuthor_id(), that.getAuthor_id()) &&
                Objects.equals(getIsbn(), that.getIsbn()) &&
                Objects.equals(getPublish_date(), that.getPublish_date()) &&
                Objects.equals(getPublisher_id(), that.getPublisher_id()) &&
                Objects.equals(getPrice(), that.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBook_id(), getIsbn(), getAuthor_id(), getPrice(), getPublish_date(), getPublisher_id(), getPrice());
    }



}
