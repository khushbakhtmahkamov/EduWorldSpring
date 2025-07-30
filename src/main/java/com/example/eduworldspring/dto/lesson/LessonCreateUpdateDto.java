package com.example.eduworldspring.dto.lesson;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class LessonCreateUpdateDto {
    @NotBlank(message = "Name can't be blank")
    private String name;

    @NotBlank(message = "Description can't be blank")
    private String description;

    private Boolean is_active;
    private LocalDate start_date;
    private LocalDate end_date;

    @NotNull(message = "Teacher id is required")
    private Long teacher_id;

    @NotNull(message = "Subject id is required")
    private Long subject_id;
}
