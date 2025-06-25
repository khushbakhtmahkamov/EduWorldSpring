package com.example.eduworldspring.dto.role;

public class RoleDto {
    private String name;
    private boolean active;

    public RoleDto() {}

    public RoleDto(String name, boolean active) {
        this.name = name;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
