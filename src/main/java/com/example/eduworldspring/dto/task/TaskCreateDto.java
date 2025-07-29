package com.example.eduworldspring.dto.task;

import com.example.eduworldspring.model.TaskLevel;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskCreateDto {
    @NotNull(message = "Question cannot be null")
    @Size(min = 1, max = 500, message = "Question must be between 1 and 500 characters")
    private String question;

    private LocalDate startDate;

    private LocalDate endDate;

    private boolean active;

    @NotNull(message = "Task level cannot be null")
    private TaskLevel level;

    @NotNull(message = "Type ID cannot be null")
    private Long typeId;

    @NotNull(message = "Lesson ID cannot be null")
    private Long lessonId;
}