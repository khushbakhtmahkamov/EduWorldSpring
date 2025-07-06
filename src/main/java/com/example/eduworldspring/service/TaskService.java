package com.example.eduworldspring.service;

import com.example.eduworldspring.model.Task;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface TaskService {
    void createTask(Task task);

    Task getTaskById(Long taskId);

    List<Task> getAllTasks();

    void updateTask(Task task);

    void deleteTask(Long taskId);

    List<Task> getTasksByLessonId(Long lessonId);

    List<Task> getTasksByTypeId(Long typeId);

    List<Task> getActiveTasks();

}
