package com.example.eduworldspring.dto.task;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskCreateDto {
    private String question;
    private String start_date;
    private String end_date;
    private boolean active;
    private int level;
    private Long typeId;
    private Long lessonId;
}
