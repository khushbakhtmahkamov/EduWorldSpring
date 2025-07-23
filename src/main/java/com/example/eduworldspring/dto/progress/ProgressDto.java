package com.example.eduworldspring.dto.progress;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ProgressDto {
    private Long id;
    private Long userId;
    private String userName;
    private Long subjectId;
    private String subjectTitle;
    private Double avgGrade;
    private Double attendance;
    private Integer totalLesson;
    private Integer completedLessons;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}