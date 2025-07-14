package com.example.eduworldspring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TypeTask {
    private Long id;
    private String title;
    private Double grade;
    private Boolean isActive;
}
