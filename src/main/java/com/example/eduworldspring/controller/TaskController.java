package com.example.eduworldspring.controller;

import com.example.eduworldspring.dto.task.TaskCreateDto;
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

    // Создание новой задачи
    @PostMapping
    public Task createTask(@RequestBody TaskCreateDto taskCreateDto) {
        Task task = new Task();
        task.setTaskId(generateTaskId()); // временная генерация ID
        task.setQuestion(taskCreateDto.getQuestion());
        task.setStart_date(taskCreateDto.getStart_date());
        task.setEnd_date(taskCreateDto.getEnd_date());
        task.setActive(taskCreateDto.isActive());
        task.setLevel(taskCreateDto.getLevel());
        task.setTypeId(taskCreateDto.getTypeId());
        task.setLessonId(taskCreateDto.getLessonId());
        taskService.createTask(task);
        return task;
    }
    private long taskIdCounter = 1;
    private Long generateTaskId() {
        return taskIdCounter++;
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

    // Получение всех активных задач
    @GetMapping("/active")
    public List<Task> getActiveTasks() {
        return taskService.getActiveTasks();
    }

    // Получение задач по lessonId
    @GetMapping("/lesson/{lessonId}")
    public List<Task> getTasksByLesson(@PathVariable("lessonId") Long lessonId) {
        return taskService.getTasksByLessonId(lessonId);
    }

    // Получение задач по typeId
    @GetMapping("/type/{typeId}")
    public List<Task> getTasksByType(@PathVariable("typeId") Long typeId) {
        return taskService.getTasksByTypeId(typeId);
    }
}
