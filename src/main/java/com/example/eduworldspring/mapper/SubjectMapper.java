package com.example.eduworldspring.mapper;

import com.example.eduworldspring.dto.schedule.ScheduleCreateUpdateDto;
import com.example.eduworldspring.dto.subject.SubjectCreateUpdateDto;
import com.example.eduworldspring.dto.subject.SubjectDto;
import com.example.eduworldspring.model.Subject;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubjectMapper {
    Subject toSubject(SubjectCreateUpdateDto scheduleCreateUpdateDto);
}
