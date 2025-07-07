package com.example.eduworldspring.dto.role;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RoleUpdateDto {
    private String name;
    private String description;
    private boolean active;

    public RoleUpdateDto() {}

    public RoleUpdateDto(String name, String description, boolean active) {
        this.name = name;
        this.description = description;
        this.active = active;
    }

}
