package com.example.eduworldspring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Role {
    private Long id;
    private String name;
    private String description;
    private boolean isActive;

}
