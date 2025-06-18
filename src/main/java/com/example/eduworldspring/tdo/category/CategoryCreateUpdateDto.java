package com.example.eduworldspring.tdo.category;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryCreateUpdateDto {
    String name;
    String description;
    boolean isActive;
}
