package com.example.eduworldspring.dto.progress;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProgressCreateUpdateDto {
    private Long userId;
    private Long subjectId;
    private Double avgGrade;
    private Double attendance;
    private Integer totalLesson;
    private Integer completedLessons;
}