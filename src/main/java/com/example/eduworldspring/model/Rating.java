package com.example.eduworldspring.model;

public class Rating{

private Long id;
private User user;
private Double grade;

    public Rating(Long id, User user, Double grade) {
        this.id = id;
        this.user = user;
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }
}