package com.example.eduworldspring.mapper;

import com.example.eduworldspring.dto.schedule.ScheduleCreateUpdateDto;
import com.example.eduworldspring.dto.schedule.ScheduleDto;
import com.example.eduworldspring.model.Lesson;
import com.example.eduworldspring.model.Schedule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ScheduleMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "description", source = "scheduleCreateUpdateDto.description")
    Schedule toSchedule(ScheduleCreateUpdateDto scheduleCreateUpdateDto, Lesson lesson);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "lessonId", source = "lesson.id")
    ScheduleDto toScheduleDto(Schedule schedule);
}