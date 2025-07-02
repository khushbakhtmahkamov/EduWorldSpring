package com.example.eduworldspring.mapper;

import com.example.eduworldspring.dto.schedule.ScheduleCreateUpdateDto;
import com.example.eduworldspring.model.Lesson;
import com.example.eduworldspring.model.Schedule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ScheduleMapper {

//    @Mapping(target = "id", defaultExpression = "java(ThreadLocalRandom.current().nextLong(1, 1000))")
    @Mapping(target = "description", source = "scheduleCreateUpdateDto.description")
    Schedule toSchedule(ScheduleCreateUpdateDto scheduleCreateUpdateDto, Long id, Lesson lesson);

    @Mapping(target = "id", source = "id")
    Schedule toScheduleForUpdate(ScheduleCreateUpdateDto scheduleCreateUpdateDto, Long id);
}
