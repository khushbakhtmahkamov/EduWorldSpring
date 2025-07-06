package com.example.eduworldspring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Task {
    private Long taskId;
    private String question;
    private String start_date;
    private String end_date;
    private boolean isActive;
    private int level;
    private Long typeId;
    private Long lessonId;

    public Task () {}

}
