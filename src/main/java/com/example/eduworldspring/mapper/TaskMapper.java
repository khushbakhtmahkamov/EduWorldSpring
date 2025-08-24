package com.example.eduworldspring.mapper;

import com.example.eduworldspring.dto.task.TaskCreateDto;
import com.example.eduworldspring.dto.task.TaskDto;
import com.example.eduworldspring.model.Lesson;
import com.example.eduworldspring.model.Task;
import com.example.eduworldspring.service.LessonService;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    @Mapping(target = "lessonId", source = "lesson.id")
    TaskDto toTaskDto(Task task);

    @Mapping(target = "lesson", source = "lessonId", qualifiedByName = "lessonIdToLesson")
    Task toTask(TaskCreateDto taskCreateDto, @Context LessonService lessonService);

    @Mapping(target = "lessonId", source = "lesson.id")
    TaskCreateDto toTaskCreateDto(Task task);

    @Named("lessonIdToLesson")
    default Lesson lessonIdToLesson(Long lessonId, @Context LessonService lessonService) {
        if (lessonId == null) {
            return null;
        }
        return lessonService.getLesson(lessonId);
    }
}