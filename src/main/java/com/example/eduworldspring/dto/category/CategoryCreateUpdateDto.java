package com.example.eduworldspring.dto.category;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryCreateUpdateDto {
    String name;
    String description;
    boolean isActive;
}
