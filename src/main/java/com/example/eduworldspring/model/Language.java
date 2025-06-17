package com.example.eduworldspring.model;

public class Language {
    String name;
    String code;
    boolean isActive;

    public Language(String name, String code, boolean isActive) {
        this.name = name;
        this.code = code;
        this.isActive = isActive;
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
