package com.example.eduworldspring.service;

import com.example.eduworldspring.dto.schedule.ScheduleCreateUpdateDto;
import com.example.eduworldspring.model.Schedule;

import java.util.ArrayList;

public interface ScheduleService {
    ArrayList<Schedule> getSchedules();
    Schedule getSchedule(Long id);
    Schedule createSchedule(ScheduleCreateUpdateDto scheduleCreateUpdateDto);
    Boolean updateSchedule(Long id, ScheduleCreateUpdateDto scheduleCreateUpdateDto);
    Boolean deleteSchedule(Long id);
}
