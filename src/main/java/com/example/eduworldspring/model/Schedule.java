package com.example.eduworldspring.model;

import com.example.eduworldspring.model.Lesson;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Schedule {
    private Long id;
    private String description;
    private Boolean isActive;
    private Lesson lesson;
}
