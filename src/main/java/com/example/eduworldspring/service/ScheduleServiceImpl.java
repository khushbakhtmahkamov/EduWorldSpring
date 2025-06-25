package com.example.eduworldspring.service;

import com.example.eduworldspring.dto.schedule.ScheduleCreateUpdateDto;
import com.example.eduworldspring.model.Schedule;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private ArrayList<Schedule> schedules = new ArrayList<>();

    public ArrayList<Schedule> getSchedules() {
        return schedules;
    }

    public Schedule getSchedule(Long id) {
        if (id == null) {
            return null;
        }


        for (Schedule schedule : schedules) {
            if (schedule.getId().equals(id)) {
                return schedule;
            }
        }
        return null;
    }

    public Schedule createSchedule(ScheduleCreateUpdateDto scheduleCreateUpdateDto) {
        Schedule schedule = Schedule.toSchedule(scheduleCreateUpdateDto);
        schedules.add(schedule);
        return schedule;
    }

    public Boolean updateSchedule(Long id, ScheduleCreateUpdateDto scheduleCreateUpdateDto) {
        if (id == null || scheduleCreateUpdateDto == null) {
            return false;
        }

        Schedule updatedSchedule = Schedule.toSchedule(scheduleCreateUpdateDto);
        updatedSchedule.setId(id);

        for (int i = 0; i < schedules.size(); i++) {
            if (schedules.get(i).getId().equals(updatedSchedule.getId())) {
                schedules.set(i, updatedSchedule);
                return true;
            }
        }
        return false;
    }

    public Boolean deleteSchedule(Long id) {
        if (id == null) {
            return false;
        }

        for ( Schedule schedule : schedules) {
            if (schedule.getId().equals(id)) {
                schedules.remove(schedule);
                return true;
            }
        }
        return false;
    }
}
