package com.example.eduworldspring.model;

public class Language {
    Long id;
    String name;
    String code;
    boolean isActive;

    public Language(Long id, String name, String code, boolean isActive) {
        this.name = name;
        this.code = code;
        this.isActive = isActive;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
