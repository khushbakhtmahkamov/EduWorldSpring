package com.example.eduworldspring.dto.category;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryCreateUpdateDto {
    @NotBlank(message = "Name can't be blank")
    String name;
    String description;
    boolean isActive;
}
