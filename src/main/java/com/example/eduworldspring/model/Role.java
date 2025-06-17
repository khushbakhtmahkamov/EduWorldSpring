package com.example.eduworldspring.model;

public class Role {
    private Long id;
    private String name;
    private String description;
    private boolean isActive;

    public Role(Long id, String name, String description, boolean isActive) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.isActive = isActive;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
