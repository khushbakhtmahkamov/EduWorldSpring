package com.example.eduworldspring.dto.task;

import com.example.eduworldspring.model.TaskLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
    private Long taskId;
    private String question;
    private String start_date;
    private String end_date;
    private boolean active;
    private TaskLevel level;
    private Long typeId;
    private Long lessonId;
}
