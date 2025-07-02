package com.example.eduworldspring.service;

import com.example.eduworldspring.dto.schedule.ScheduleCreateUpdateDto;
import com.example.eduworldspring.exceptions.BusinessExceptionCode;
import com.example.eduworldspring.exceptions.BusinessRuntimeException;
import com.example.eduworldspring.mapper.ScheduleMapper;
import com.example.eduworldspring.model.Lesson;
import com.example.eduworldspring.model.Schedule;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleMapper scheduleMapper;
    @Getter
    private ArrayList<Schedule> schedules = new ArrayList<>();
    private final LessonService lessonService;

    public Schedule getSchedule(Long id) {
        if (id == null) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "Id cannot be null");
        }

        for (Schedule schedule : schedules) {
            if (schedule.getId().equals(id)) {
                return schedule;
            }
        }
        throw new BusinessRuntimeException(BusinessExceptionCode.NOT_FOUND, "Schedule with id " + id + "not found");
    }

    public Schedule createSchedule(ScheduleCreateUpdateDto scheduleCreateUpdateDto) {
        Lesson lesson = lessonService.getLesson(scheduleCreateUpdateDto.getLessonId());

        if (lesson == null) {
            throw new BusinessRuntimeException(BusinessExceptionCode.NOT_FOUND, "Lesson not found");
        }

        Schedule schedule = scheduleMapper.toSchedule(scheduleCreateUpdateDto, ThreadLocalRandom.current().nextLong(1,100), lesson);
        schedules.add(schedule);
        return schedule;
    }

    public Boolean updateSchedule(Long id, ScheduleCreateUpdateDto scheduleCreateUpdateDto) {
        if (id == null) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "Id cannot be null");
        }
        if (scheduleCreateUpdateDto == null) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "ScheduleCreateUpdateDto cannot be null");
        }

        Schedule updatedSchedule = scheduleMapper.toScheduleForUpdate(scheduleCreateUpdateDto, id);

        for (int i = 0; i < schedules.size(); i++) {
            if (schedules.get(i).getId().equals(updatedSchedule.getId())) {
                schedules.set(i, updatedSchedule);
                return true;
            }
        }
        throw new BusinessRuntimeException(BusinessExceptionCode.NOT_FOUND, "Schedule not found");
    }

    public Boolean deleteSchedule(Long id) {
        if (id == null) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "Id cannot be null");
        }

        for ( Schedule schedule : schedules) {
            if (schedule.getId().equals(id)) {
                schedules.remove(schedule);
                return true;
            }
        }
        throw new BusinessRuntimeException(BusinessExceptionCode.NOT_FOUND, "Schedule not found");
    }
}
