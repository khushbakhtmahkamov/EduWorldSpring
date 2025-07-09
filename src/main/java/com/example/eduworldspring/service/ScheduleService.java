package com.example.eduworldspring.service;

import com.example.eduworldspring.dto.schedule.ScheduleCreateUpdateDto;
import com.example.eduworldspring.model.Schedule;

import java.util.List;

public interface ScheduleService {
    List<Schedule> getSchedules();
    Schedule getSchedule(Long id);
    Schedule createSchedule(ScheduleCreateUpdateDto scheduleCreateUpdateDto);
    Boolean updateSchedule(Long id, ScheduleCreateUpdateDto scheduleCreateUpdateDto);
    Boolean deleteSchedule(Long id);
}
