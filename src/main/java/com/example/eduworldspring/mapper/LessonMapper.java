package com.example.eduworldspring.mapper;

import com.example.eduworldspring.dto.lesson.LessonCreateUpdateDto;
import com.example.eduworldspring.model.Lesson;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LessonMapper {

    Lesson toEntity(LessonCreateUpdateDto lessonCreateUpdateDto, Long id);
}