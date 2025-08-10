package com.example.eduworldspring.dto.lesson;

import com.example.eduworldspring.model.Lesson;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class LessonDto extends @NotNull(message = "Lesson cannot be null")Lesson {
    private Long id;
    private String name;
    private String description;
    private Boolean is_active;
    private LocalDate start_date;
    private LocalDate end_date;
    private Long teacher_id;
    private Long subject_id;
}
