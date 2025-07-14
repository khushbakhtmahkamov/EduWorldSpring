package com.example.eduworldspring.dto.role;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RoleDto {
    private Long id;
    private String name;
    private String description;
    private boolean active;

    public RoleDto() {}

    public RoleDto(String name, boolean active) {
        this.name = name;
        this.active = active;
    }

}
