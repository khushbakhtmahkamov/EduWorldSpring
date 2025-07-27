package com.example.eduworldspring.controller;

import com.example.eduworldspring.dto.task.TaskCreateDto;
import com.example.eduworldspring.model.Task;
import com.example.eduworldspring.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @PostMapping
    public Task createTask(@RequestBody TaskCreateDto taskCreateDto) {
        Task task = new Task();
        task.setTaskId(generateTaskId());
        task.setQuestion(taskCreateDto.getQuestion());
        task.setStart_date(taskCreateDto.getStart_date());
        task.setEnd_date(taskCreateDto.getEnd_date());
        task.setActive(taskCreateDto.isActive());
        task.setLevel(taskCreateDto.getLevel());
        task.setTypeId(taskCreateDto.getTypeId());

        taskService.createTask(task);
        return task;
    }

    private long taskIdCounter = 1;
    private Long generateTaskId() {
        return taskIdCounter++;
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable("id") Long id) {
        Task task = taskService.getTaskById(id);
        return ResponseEntity.ok(task);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable("id") Long id, @RequestBody Task task) {
        task.setTaskId(id);
        taskService.updateTask(task);
        return ResponseEntity.ok(task);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable("id") Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/active")
    public ResponseEntity<List<Task>> getActiveTasks() {
        List<Task> activeTasks = taskService.getActiveTasks();
        return ResponseEntity.ok(activeTasks);
    }

    @GetMapping("/lesson/{lessonId}")
    public ResponseEntity<List<Task>> getTasksByLesson(@PathVariable("lessonId") Long lessonId) {
        List<Task> tasks = taskService.getTasksByLessonId(lessonId);
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/type/{typeId}")
    public ResponseEntity<List<Task>> getTasksByType(@PathVariable("typeId") Long typeId) {
        List<Task> tasks = taskService.getTasksByTypeId(typeId);
        return ResponseEntity.ok(tasks);
    }
}