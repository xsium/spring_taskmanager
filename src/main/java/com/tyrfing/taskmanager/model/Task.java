package com.tyrfing.taskmanager.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tasks")
public class Task {
    // attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "creation_date")
    private Date date;
    @Column(name = "status")
    private boolean status;

    @ManyToMany
    @JoinTable(name = "tasks_categories", joinColumns = @JoinColumn(name = "task_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Task() {
    }

    public Task(String title, String description, Date date, boolean status) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.status = status;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isStatus() {
        return this.status;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Category> getCategories() {
        return this.categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", title='" + getTitle() + "'" +
                ", description='" + getDescription() + "'" +
                ", date='" + getDate() + "'" +
                ", status='" + isStatus() + "'" +
                ", categories='" + getCategories() + "'" +
                "}";
    }

}
