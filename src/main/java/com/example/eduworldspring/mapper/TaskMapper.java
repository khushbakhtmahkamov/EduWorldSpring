package com.example.eduworldspring.mapper;

import com.example.eduworldspring.dto.task.TaskCreateDto;
import com.example.eduworldspring.dto.task.TaskDto;
import com.example.eduworldspring.model.Lesson;
import com.example.eduworldspring.model.Task;
import com.example.eduworldspring.service.LessonService;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    @Mapping(target = "lesson", source = "lessonId", qualifiedByName = "lessonIdToLesson")
    @Mapping(target = "taskId", ignore = true)
    @Mapping(target = "question", source = "question")
    @Mapping(target = "start_date", source = "start_date")
    @Mapping(target = "end_date", source = "end_date")
    @Mapping(target = "active", source = "active")
    @Mapping(target = "level", source = "level")
    @Mapping(target = "typeId", source = "typeId")
    Task toTask(TaskCreateDto taskCreateDto, @Context LessonService lessonService);

    @Named("lessonIdToLesson")
    default Lesson lessonIdToLesson(Long lessonId, @Context LessonService lessonService) {
        return lessonService.getLesson(lessonId);
    }

    @Mapping(target = "lessonId", source = "lesson.id")
    @Mapping(target = "active", source = "active")
    TaskCreateDto toTaskCreateDto(Task task);

    @Mapping(target = "lessonId", source = "lesson.id")
    @Mapping(target = "active", source = "active")
    TaskDto toTaskDto(Task task);
}