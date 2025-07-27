package com.example.eduworldspring.mapper;

import com.example.eduworldspring.dto.task.TaskCreateDto;
import com.example.eduworldspring.model.Lesson;
import com.example.eduworldspring.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    @Mapping(target = "lesson", source = "lesson")
    @Mapping(target = "question", source = "taskCreateDto.question")
    @Mapping(target = "start_date", source = "taskCreateDto.start_date")
    @Mapping(target = "end_date", source = "taskCreateDto.end_date")
    @Mapping(target = "active", source = "taskCreateDto.active")
    @Mapping(target = "level", source = "taskCreateDto.level")
    @Mapping(target = "typeId", source = "taskCreateDto.typeId")
    Task toTask(TaskCreateDto taskCreateDto, Lesson lesson);

    @Mapping(target = "lessonId", source = "lesson.lesson_id")
    TaskCreateDto toTaskCreateDto(Task task);
}

