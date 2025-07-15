package com.example.eduworldspring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TypeTask {
    private Long id;
    private String title;
    private Double grade;
    private Boolean isActive;
}
