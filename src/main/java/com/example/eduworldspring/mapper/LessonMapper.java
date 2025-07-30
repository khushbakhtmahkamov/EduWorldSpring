package com.example.eduworldspring.mapper;

import com.example.eduworldspring.dto.lesson.LessonCreateUpdateDto;
import com.example.eduworldspring.dto.lesson.LessonDto;
import com.example.eduworldspring.model.Lesson;
import com.example.eduworldspring.model.Subject;
import com.example.eduworldspring.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface LessonMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "lessonCreateUpdateDto.name")
    @Mapping(target = "description", source = "lessonCreateUpdateDto.description")
    @Mapping(target = "teacher", source = "teacher")
    @Mapping(target = "subject", source = "subject")
    Lesson toLesson(LessonCreateUpdateDto lessonCreateUpdateDto, User teacher, Subject subject);


    @Mapping(target = "teacher_id", source = "id")
    @Mapping(target = "subject_id", source = "subject.id")
    LessonDto toLessonDto(Lesson lesson);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "lessonCreateUpdateDto.name")
    @Mapping(target = "description", source = "lessonCreateUpdateDto.description")
    @Mapping(target = "subject", source = "subject")
    @Mapping(target = "teacher", source = "user")
    void updateLessonFromDto(LessonCreateUpdateDto lessonCreateUpdateDto, User user, Subject subject, @MappingTarget Lesson lesson);



}