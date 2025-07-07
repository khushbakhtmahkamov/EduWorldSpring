package com.example.eduworldspring.mapper;

import com.example.eduworldspring.dto.task.TaskCreateDto;
import com.example.eduworldspring.model.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    public static Task toEntity(TaskCreateDto dto) {
        return new Task(
                null, // taskId будет сгенерирован автоматически или вручную задан
                dto.getQuestion(),
                dto.getStart_date(),
                dto.getEnd_date(),
                dto.isActive(),
                dto.getLevel(),
                dto.getTypeId(),
                dto.getLessonId()
        );
    }

}
