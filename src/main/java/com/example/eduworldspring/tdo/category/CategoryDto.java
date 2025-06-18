package com.example.eduworldspring.tdo.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CategoryDto {
    Long id;
    String name;
    String description;
    boolean isActive;
}
