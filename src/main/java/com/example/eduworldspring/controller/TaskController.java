package com.example.eduworldspring.controller;

import com.example.eduworldspring.model.Task;
import com.example.eduworldspring.dto.task.TaskCreateDto;
import com.example.eduworldspring.dto.task.TaskDto;
import com.example.eduworldspring.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/{id}")
    public TaskDto getTask(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @GetMapping
    public List<TaskDto> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping
    public TaskDto createTask(@RequestBody TaskCreateDto taskCreateDto) {
        return taskService.createTask(taskCreateDto);
    }

    @PutMapping("/{id}")
    public TaskDto updateTask(@PathVariable Long id, @RequestBody TaskCreateDto taskCreateDto) {
        return taskService.updateTask(id, taskCreateDto);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

    @GetMapping("/by-lesson/{lessonId}")
    public List<TaskDto> getTasksByLessonId(@PathVariable Long lessonId) {
        return taskService.getTasksByLessonId(lessonId);
    }
}
