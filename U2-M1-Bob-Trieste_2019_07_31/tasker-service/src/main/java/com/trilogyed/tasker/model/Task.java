package com.trilogyed.tasker.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

public class Task {

    private int id;
    private String description;
    private LocalDate createDate;
    private LocalDate dueDate;
    private String category;
    private String advertisement;

    public Task(int id, String description, LocalDate createDate, LocalDate dueDate, String category, String advertisement) {
        this.id = id;
        this.description = description;
        this.createDate = createDate;
        this.dueDate = dueDate;
        this.category = category;
        this.advertisement = advertisement;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

//    public void setCreateDate(Date createDate) {
//        this.createDate = createDate;
//    }

    public LocalDate getDueDate() {
        return dueDate;
    }

//    public void setDueDate(Date dueDate) {
//        this.dueDate = dueDate;
//    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(String advertisement) {
        this.advertisement = advertisement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id &&
                Objects.equals(description, task.description) &&
                Objects.equals(createDate, task.createDate) &&
                Objects.equals(dueDate, task.dueDate) &&
                Objects.equals(category, task.category);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, description, createDate, dueDate, category);
    }
}

