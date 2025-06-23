package com.example.eduworldspring.dto.schedule;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ScheduleCreateUpdateDto {
    private String description;
    private Boolean is_active;
    private Long lesson_id;
}
