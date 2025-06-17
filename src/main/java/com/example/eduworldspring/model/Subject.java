package com.example.eduworldspring.model;

public class Subject {
    private String title;
    private String code;
    private int credits;
    private String description;

    public Subject() {
        this.title = title;
        this.code = code;
        this.credits = credits;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "title='" + title + '\'' +
                ", code='" + code + '\'' +
                ", credits=" + credits +
                ", description='" + description + '\'' +
                '}';
    }
}