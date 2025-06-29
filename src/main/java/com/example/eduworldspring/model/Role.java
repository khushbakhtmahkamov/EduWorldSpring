package com.example.eduworldspring.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
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

}
