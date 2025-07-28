package com.example.eduworldspring.dto.subject;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectCreateUpdateDto {
    private String title;
    private String code;
    private Integer credits;
    private String description;
    private Long categoryId;
}