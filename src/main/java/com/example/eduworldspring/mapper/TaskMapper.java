package com.example.eduworldspring.mapper;

import com.example.eduworldspring.dto.task.TaskCreateDto;
import com.example.eduworldspring.dto.task.TaskDto;
import com.example.eduworldspring.exceptions.BusinessRuntimeException;
import com.example.eduworldspring.exceptions.BusinessExceptionCode;
import com.example.eduworldspring.model.Lesson;
import com.example.eduworldspring.model.Task;
import com.example.eduworldspring.service.LessonService;
import org.mapstruct.*;
import java.util.Objects;

// Mapper interface for converting between Task entities and DTOs
@Mapper(componentModel = "spring")
public interface TaskMapper {
    // Converts a TaskCreateDto to a Task entity, fetching the associated Lesson using LessonService
    @Mapping(target = "lesson", source = "lessonId", qualifiedByName = "lessonIdToLesson")
    @Mapping(target = "question", source = "question")
    @Mapping(target = "startDate", source = "startDate")
    @Mapping(target = "endDate", source = "endDate")
    @Mapping(target = "active", source = "active")
    @Mapping(target = "level", source = "level")
    @Mapping(target = "typeId", source = "typeId")
    Task toTask(TaskCreateDto taskCreateDto, @Context LessonService lessonService);
    // Maps a lessonId to a Lesson entity using LessonService
    @Named("lessonIdToLesson")
    default Lesson lessonIdToLesson(Long lessonId, @Context LessonService lessonService) {
        if (Objects.isNull(lessonId)) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "Lesson ID cannot be null");
        }
        return lessonService.getLesson(lessonId); // Предполагается, что getLesson выбросит BusinessRuntimeException, если урок не найден
    }
    // Converts a Task entity to a TaskCreateDto
    @Mapping(target = "lessonId", source = "lesson.id")
    @Mapping(target = "question", source = "question")
    @Mapping(target = "startDate", source = "startDate")
    @Mapping(target = "endDate", source = "endDate")
    @Mapping(target = "active", source = "active")
    @Mapping(target = "level", source = "level")
    @Mapping(target = "typeId", source = "typeId")
    TaskCreateDto toTaskCreateDto(Task task);
    //Converts a Task entity to a TaskDto
    @Mapping(target = "lessonId", source = "lesson.id")
    @Mapping(target = "question", source = "question")
    @Mapping(target = "startDate", source = "startDate")
    @Mapping(target = "endDate", source = "endDate")
    @Mapping(target = "active", source = "active")
    @Mapping(target = "level", source = "level")
    @Mapping(target = "typeId", source = "typeId")
    @Mapping(target = "id", source = "id")
    TaskDto toTaskDto(Task task);
}