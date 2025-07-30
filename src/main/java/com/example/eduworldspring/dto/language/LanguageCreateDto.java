package com.example.eduworldspring.dto.language;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LanguageCreateDto {
    private String name;
    private String code;
    private Boolean isActive;
}
