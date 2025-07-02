package com.example.eduworldspring.dto.schedule;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScheduleCreateUpdateDto {
    private String description;
    private Boolean isActive;
    private Long lessonId;
}
