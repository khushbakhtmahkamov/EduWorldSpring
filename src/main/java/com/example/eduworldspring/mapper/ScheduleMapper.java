package com.example.eduworldspring.mapper;

import com.example.eduworldspring.dto.schedule.ScheduleCreateUpdateDto;
import com.example.eduworldspring.model.Schedule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ScheduleMapper {

   // @Mapping(target = "id", defaultExpression = "java(ThreadLocalRandom.current().nextLong(1, 1000))")
    Schedule toEntity(ScheduleCreateUpdateDto scheduleCreateUpdateDto, Long id);
}
