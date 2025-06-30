package com.example.eduworldspring.model;

import com.example.eduworldspring.dto.schedule.ScheduleCreateUpdateDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.ThreadLocalRandom;

@Setter
@Getter
@AllArgsConstructor
public class Schedule {
    private Long id;
    private String description;
    private Boolean isActive;
    private Long lessonId;

    public Schedule() {}
}
