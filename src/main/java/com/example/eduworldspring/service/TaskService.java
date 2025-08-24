package com.example.eduworldspring.service;

import com.example.eduworldspring.dto.task.TaskCreateDto;
import com.example.eduworldspring.dto.task.TaskDto;
import com.example.eduworldspring.model.TaskLevel;

import java.time.LocalDate;
import java.util.List;

public interface TaskService {

    TaskDto createTask(TaskCreateDto taskCreateDto);

    TaskDto getTaskById(Long taskId);

    List<TaskDto> getAllTasks();

    TaskDto updateTask(Long id, TaskCreateDto taskCreateDto);

    Boolean deleteTask(Long taskId);

    List<TaskDto> getTasksByLessonId(Long lessonId);

    List<TaskDto> getTasksByTypeId(Long typeId);

    List<TaskDto> getActiveTasks();

    List<TaskDto> getTasksByDateRange(LocalDate startDate, LocalDate endDate);

    List<TaskDto> getTasksByLevel(TaskLevel level);
}
