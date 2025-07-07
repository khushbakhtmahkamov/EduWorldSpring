package com.example.eduworldspring.service;

import com.example.eduworldspring.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

    @Service
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
        public void updateTask(Task updatedTask) {  // Обновляет task в списке по совпадающему id
            for (int i = 0; i < taskList.size(); i++) {
                Task current = taskList.get(i);
                if (current.getTaskId().equals(updatedTask.getTaskId())) {
                    taskList.set(i, updatedTask);
                    break;
                }
            }
        }

        @Override
        public void deleteTask(Long taskId) {  // Удаляет задачу по идентификатору
            taskList.removeIf(task -> task.getTaskId().equals(taskId));
        }

        @Override
        public List<Task> getTasksByLessonId(Long lessonId) { // Возвращает список задач, связанных с указанным уроком
            List<Task> result = new ArrayList<>();
            for (Task task : taskList) {
                if (task.getLessonId().equals(lessonId)) {
                    result.add(task);
                }
            }
            return result;
        }

        @Override
        public List<Task> getTasksByTypeId(Long typeId) { // Возвращает задачи, относящиеся к определённому типу
            List<Task> result = new ArrayList<>();
            for (Task task : taskList) {
                if (task.getTypeId().equals(typeId)) {
                    result.add(task);
                }
            }
            return result;
        }

        @Override
        public List<Task> getActiveTasks() { //Возвращает все активные задачи (isActive == true)
            List<Task> result = new ArrayList<>();
            for (Task task : taskList) {
                if (task.isActive()) {
                    result.add(task);
                }
            }
            return result;
        }
    }


