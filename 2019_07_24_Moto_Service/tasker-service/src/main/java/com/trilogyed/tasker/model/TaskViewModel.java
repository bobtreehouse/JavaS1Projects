package com.trilogyed.tasker.model;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.Objects;

public class TaskViewModel {

    private int id;
    @NotEmpty(message = "Enter description")
    private String description;
    @NotEmpty(message = "Enter a date")
    private LocalDate createDate;
    @NotEmpty(message = "Enter a date")
    private LocalDate dueDate;
    @NotEmpty(message = "Enter category")
    private String category;
    private String advertisement;

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

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

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
        return id == task.getId() &&
                Objects.equals(description, task.getDescription()) &&
                Objects.equals(createDate, task.getCreateDate()) &&
                Objects.equals(dueDate, task.getDueDate()) &&
                Objects.equals(category, task.getCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDescription(), getCreateDate(), getDueDate(), getCategory());
    }




}
