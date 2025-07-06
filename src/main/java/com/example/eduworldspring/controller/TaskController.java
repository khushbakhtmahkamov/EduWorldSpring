package com.example.eduworldspring.controller;

import com.example.eduworldspring.model.Task;
import com.example.eduworldspring.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;
    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    private static TaskController createTaskController(TaskService taskService) {
        return new TaskController(taskService);
    }

    // Создание новой задачи
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        taskService.createTask(task);
        return task;
    }

    // Получение всех задач
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    // Получение задачи по ID
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable("id") Long id) {
        return taskService.getTaskById(id);
    }

    // Обновление задачи
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable("id") Long id, @RequestBody Task task) {
        task.setTaskId(id);  // Убедимся, что ID совпадает
        taskService.updateTask(task);
        return task;
    }

    // Удаление задачи
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable("id") Long id) {
        taskService.deleteTask(id);
    }

    // ✅ Получение всех активных задач
    @GetMapping("/active")
    public List<Task> getActiveTasks() {
        return taskService.getActiveTasks();
    }

    // 🔎 Получение задач по lessonId
    @GetMapping("/lesson/{lessonId}")
    public List<Task> getTasksByLesson(@PathVariable("lessonId") Long lessonId) {
        return taskService.getTasksByLessonId(lessonId);
    }

    // 🔎 Получение задач по typeId
    @GetMapping("/type/{typeId}")
    public List<Task> getTasksByType(@PathVariable("typeId") Long typeId) {
        return taskService.getTasksByTypeId(typeId);
    }
}
