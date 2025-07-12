package com.example.eduworldspring.model;

public class Rating{

private Long id;
private User user;
private Double grade;
//    private Progress progress;

    public Rating(Long id, User user, Double grade){ //, Progress progress) {
        this.id = id;
        this.user = user;
        this.grade = grade;
//        this.progress = progress;
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
//
//    public Progress getProgress() {
//        return progress;
//    }
//
//    public void setProgress(Progress progress) {
//        this.progress = progress;
//    }
}