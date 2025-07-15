package com.example.eduworldspring.service;

import com.example.eduworldspring.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service  // Добавляем аннотацию @Service
public class TaskServiceImpl implements TaskService {

    private final List<Task> taskList = new ArrayList<>();

    @Override
    public void createTask(Task task) {
        taskList.add(task);
    }

    @Override
    public Task getTaskById(Long taskId) {
        for (Task task : taskList) {
            if (task.getTaskId().equals(taskId)) {
                return task;
            }
        }
        return null;
    }

    @Override
    public List<Task> getAllTasks() {
        return new ArrayList<>(taskList);
    }

    @Override
    public void updateTask(Task updatedTask) {
        for (int i = 0; i < taskList.size(); i++) {
            Task current = taskList.get(i);
            if (current.getTaskId().equals(updatedTask.getTaskId())) {
                taskList.set(i, updatedTask);
                break;
            }
        }
    }

    @Override
    public void deleteTask(Long taskId) {
        taskList.removeIf(task -> task.getTaskId().equals(taskId));
    }

    @Override
    public List<Task> getTasksByLessonId(Long lessonId) {
        List<Task> result = new ArrayList<>();
        for (Task task : taskList) {
            // Исправляем: сначала проверяем lessonId, потом lesson.lesson_id
            if (task.getLessonId() != null && task.getLessonId().equals(lessonId)) {
                result.add(task);
            } else if (task.getLesson() != null && task.getLesson().getLesson_id().equals(lessonId)) {
                result.add(task);
            }
        }
        return result;
    }

    @Override
    public List<Task> getTasksByTypeId(Long typeId) {
        List<Task> result = new ArrayList<>();
        for (Task task : taskList) {
            if (task.getTypeId().equals(typeId)) {
                result.add(task);
            }
        }
        return result;
    }

    @Override
    public List<Task> getActiveTasks() {
        List<Task> result = new ArrayList<>();
        for (Task task : taskList) {
            if (task.isActive()) {
                result.add(task);
            }
        }
        return result;
    }
}