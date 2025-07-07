package com.example.eduworldspring.mapper;

import com.example.eduworldspring.dto.lesson.LessonCreateUpdateDto;
import com.example.eduworldspring.model.Lesson;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface LessonMapper {

    Lesson toLesson(LessonCreateUpdateDto lessonCreateUpdateDto, Long id);
}