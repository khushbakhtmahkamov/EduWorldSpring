package com.example.eduworldspring.service;

import com.example.eduworldspring.dto.task.TaskCreateDto;
import com.example.eduworldspring.dto.task.TaskDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface TaskService {
    TaskDto createTask(TaskCreateDto taskCreateDto);

    TaskDto getTaskById(Long taskId);

    List<TaskDto> getAllTasks();

    TaskDto updateTask(Long id, TaskCreateDto taskCreateDto);

    Boolean deleteTask(Long taskId);

    List<TaskDto> getTasksByLessonId(Long lessonId);

    List<TaskDto> getTasksByTypeId(Long typeId);

    List<TaskDto> getActiveTasks();

}
