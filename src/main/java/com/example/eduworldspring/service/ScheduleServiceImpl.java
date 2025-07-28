package com.example.eduworldspring.service;

import com.example.eduworldspring.dto.schedule.ScheduleCreateUpdateDto;
import com.example.eduworldspring.dto.schedule.ScheduleDto;
import com.example.eduworldspring.exceptions.BusinessExceptionCode;
import com.example.eduworldspring.exceptions.BusinessRuntimeException;
import com.example.eduworldspring.mapper.ScheduleMapper;
import com.example.eduworldspring.model.Lesson;
import com.example.eduworldspring.model.Schedule;
import com.example.eduworldspring.repository.LessonRepository;
import com.example.eduworldspring.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final ScheduleMapper scheduleMapper;
    private final LessonRepository lessonRepository;

    public List<ScheduleDto> getSchedules() {
        return scheduleRepository.findAll().stream().map(scheduleMapper::toScheduleDto).toList();
    }

    public ScheduleDto getSchedule(Long id) {
        if (id == null) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "Id cannot be null");
        }

        Schedule schedule = scheduleRepository.findById(id).orElseThrow(() ->
                new BusinessRuntimeException(BusinessExceptionCode.NOT_FOUND, "Schedule with id " + id + " not found"));

        return scheduleMapper.toScheduleDto(schedule);
    }

    public Schedule createSchedule(ScheduleCreateUpdateDto scheduleCreateUpdateDto) {
        Lesson lesson = lessonRepository.findById(scheduleCreateUpdateDto.getLessonId())
                .orElseThrow(() -> new BusinessRuntimeException(
                        BusinessExceptionCode.NOT_FOUND,
                        "Lesson with id " + scheduleCreateUpdateDto.getLessonId() + " not found"
                ));

        Schedule schedule = scheduleMapper.toSchedule(scheduleCreateUpdateDto, lesson);
        scheduleRepository.save(schedule);
        return schedule;
    }

    public Boolean updateSchedule(Long id, ScheduleCreateUpdateDto scheduleCreateUpdateDto) {
//        if (id == null) {
//            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "Id cannot be null");
//        }
//        if (scheduleCreateUpdateDto == null) {
//            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "ScheduleCreateUpdateDto cannot be null");
//        }
//        if (scheduleCreateUpdateDto.getLessonId() == null) {
//            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "LessonId cannot be null");
//        }
//
//        Schedule schedule = scheduleRepository.findById(id).orElseThrow(() ->
//                new BusinessRuntimeException(BusinessExceptionCode.NOT_FOUND, "Schedule with id " + id + " not found"));
//
//        // Updating schedule fields
//        schedule.setDescription(scheduleCreateUpdateDto.getDescription());
//
//        Lesson lesson = lessonService.getLesson(scheduleCreateUpdateDto.getLessonId());
//        schedule.setLesson(lesson);
//
//        schedule.setIsActive(scheduleCreateUpdateDto.getIsActive());
//
//        scheduleRepository.save(schedule);
        return true;
    }


    public Boolean deleteSchedule(Long id) {
        if (id == null) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "Id cannot be null");
        }

        scheduleRepository.findById(id).orElseThrow(() ->
                new BusinessRuntimeException(BusinessExceptionCode.NOT_FOUND, "Schedule with id " + id + " not found"));

        scheduleRepository.deleteById(id);
        return true;
    }
}