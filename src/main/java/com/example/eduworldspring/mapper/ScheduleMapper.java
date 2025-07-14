package com.example.eduworldspring.mapper;

import com.example.eduworldspring.dto.schedule.ScheduleCreateUpdateDto;
import com.example.eduworldspring.dto.schedule.ScheduleDto;
import com.example.eduworldspring.model.Lesson;
import com.example.eduworldspring.model.Schedule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ScheduleMapper {


    @Mapping(target = "description", source = "scheduleCreateUpdateDto.description")
    Schedule toSchedule(ScheduleCreateUpdateDto scheduleCreateUpdateDto, Lesson lesson);

    ScheduleDto toScheduleDto(Schedule schedule);
}
