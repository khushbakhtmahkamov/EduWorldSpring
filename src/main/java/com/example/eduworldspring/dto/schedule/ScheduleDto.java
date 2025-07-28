package com.example.eduworldspring.dto.schedule;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ScheduleDto {
    private long id;
    private String description;
    private Boolean isActive;
    private Long lessonId;
}