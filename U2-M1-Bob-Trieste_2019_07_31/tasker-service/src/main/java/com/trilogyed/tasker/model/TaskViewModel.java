
package com.trilogyed.tasker.model;
import java.time.LocalDate;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;

public class TaskViewModel {



    private int id;
    @NotEmpty(message = "You must supply a value for desc.")
    @Size(min = 5, max = 255, message = "between 5 & 255 characters in length.")
    private String description;

    @NotEmpty(message = "You must supply a value for createDate.")
    private LocalDate createDate;

    @NotEmpty(message = "You must supply a value for dueDate.")
    private LocalDate dueDate;

    @NotEmpty(message = "You must supply a value for category.")
    private String category;

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




}

