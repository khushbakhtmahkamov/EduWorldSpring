package com.example.eduworldspring.controller;

import com.example.eduworldspring.dto.task.TaskCreateDto;
import com.example.eduworldspring.dto.task.TaskDto;
import com.example.eduworldspring.mapper.TaskMapper;
import com.example.eduworldspring.model.Task;
import com.example.eduworldspring.service.TaskService;
import com.example.eduworldspring.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;
    private final LessonService lessonService;

    private long taskIdCounter = 1;

    @Autowired
    public TaskController(TaskService taskService, TaskMapper taskMapper, LessonService lessonService) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
        this.lessonService = lessonService;
    }


    @PostMapping
    public TaskDto createTask(@RequestBody TaskCreateDto taskCreateDto) {
        Task task = taskMapper.toTask(taskCreateDto, lessonService);
        task.setTaskId(generateTaskId());
        taskService.createTask(task);
        return taskMapper.toTaskDto(task);
    }

    private Long generateTaskId() {
        return taskIdCounter++;
    }

    // Получение всех задач в виде списка DTO
    @GetMapping
    public List<TaskDto> getAllTasks() {
        return taskService.getAllTasks()
                .stream()
                .map(taskMapper::toTaskDto)
                .collect(Collectors.toList());
    }

    // Получение задачи по id
    @GetMapping("/{id}")
    public TaskDto getTaskById(@PathVariable("id") Long id) {
        Task task = taskService.getTaskById(id);
        return taskMapper.toTaskDto(task);
    }

    // Обновление задачи по id
    @PutMapping("/{id}")
    public TaskDto updateTask(@PathVariable("id") Long id, @RequestBody TaskCreateDto taskCreateDto) {
        Task task = taskMapper.toTask(taskCreateDto, lessonService);
        task.setTaskId(id);
        taskService.updateTask(task);
        return taskMapper.toTaskDto(task);
    }

    // Удаление задачи по id
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable("id") Long id) {
        taskService.deleteTask(id);
    }

    // Получение всех активных задач
    @GetMapping("/active")
    public List<TaskDto> getActiveTasks() {
        return taskService.getActiveTasks()
                .stream()
                .map(taskMapper::toTaskDto)
                .collect(Collectors.toList());
    }

    // Получение задач по уроку
    @GetMapping("/lesson/{lessonId}")
    public List<TaskDto> getTasksByLesson(@PathVariable("lessonId") Long lessonId) {
        return taskService.getTasksByLessonId(lessonId)
                .stream()
                .map(taskMapper::toTaskDto)
                .collect(Collectors.toList());
    }

    // Получение задач по типу
    @GetMapping("/type/{typeId}")
    public List<TaskDto> getTasksByType(@PathVariable("typeId") Long typeId) {
        return taskService.getTasksByTypeId(typeId)
                .stream()
                .map(taskMapper::toTaskDto)
                .collect(Collectors.toList());
    }
}
