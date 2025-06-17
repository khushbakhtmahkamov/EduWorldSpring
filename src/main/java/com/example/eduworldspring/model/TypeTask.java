package com.example.eduworldspring.model;

public class TypeTask {
    private Long id;
    private String title;
    private Double grade;
    private Boolean isActive;

    public TypeTask(Long id, String title, Double grade, Boolean isActive) {
        this.id = id;
        this.title = title;
        this.grade = grade;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
