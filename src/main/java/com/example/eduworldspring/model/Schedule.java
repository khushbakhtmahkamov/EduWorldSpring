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
    private Boolean is_active;
    private Long lesson_id;

    public Schedule() {}

    public static Schedule toSchedule(ScheduleCreateUpdateDto scheduleCreateUpdateDto) {
        return new Schedule(
                ThreadLocalRandom.current().nextLong(),
                scheduleCreateUpdateDto.getDescription(),
                scheduleCreateUpdateDto.getIs_active(),
                scheduleCreateUpdateDto.getLesson_id()
        );
    }
}
