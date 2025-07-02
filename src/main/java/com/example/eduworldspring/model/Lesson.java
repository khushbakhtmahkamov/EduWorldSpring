package com.example.eduworldspring.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Lesson {
    private Long lesson_id;
    private String name;
    private String description;
    private Boolean is_active;
    private String start_date;
    private String end_date;
    private Long subject_id;
    private Long teacher_id;

    public Lesson() {

    }
}
