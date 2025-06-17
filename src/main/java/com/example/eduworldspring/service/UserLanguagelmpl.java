package com.example.eduworldspring.service;

public class UserLanguagelmpl {
    private String name;
    private String code;
    private boolean isActive;

    public UserLanguagelmpl(String language, String code, boolean isActive) {
        this.name = language;
        this.code = code;
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
