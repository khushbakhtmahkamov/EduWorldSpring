package com.example.eduworldspring.service;

import com.example.eduworldspring.dto.task.TaskCreateDto;
import com.example.eduworldspring.dto.task.TaskDto;
import com.example.eduworldspring.mapper.TaskMapper;
import com.example.eduworldspring.model.Lesson;
import com.example.eduworldspring.model.Task;
import com.example.eduworldspring.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final LessonService lessonService;
    private final TaskMapper taskMapper;

    public TaskServiceImpl(TaskRepository taskRepository, LessonService lessonService, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.lessonService = lessonService;
        this.taskMapper = taskMapper;
    }

    @Override
    public TaskDto createTask(TaskCreateDto taskCreateDto) {
        Task task = taskMapper.toTask(taskCreateDto, lessonService);
        return taskMapper.toTaskDto(taskRepository.save(task));
    }

    @Override
    public TaskDto getTaskById(Long taskId) {
        return taskRepository.findById(taskId)
                .map(taskMapper::toTaskDto)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + taskId));
    }

    @Override
    public List<TaskDto> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(taskMapper::toTaskDto)
                .collect(Collectors.toList());
    }

    @Override
    public TaskDto updateTask(Long id, TaskCreateDto taskCreateDto) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));

        Task updatedTask = taskMapper.toTask(taskCreateDto, lessonService);
        updatedTask.setId(task.getId()); // сохранить ID

        return taskMapper.toTaskDto(taskRepository.save(updatedTask));
    }

    @Override
    public Boolean deleteTask(Long taskId) {
        if (!taskRepository.existsById(taskId)) {
            return false;
        }
        taskRepository.deleteById(taskId);
        return true;
    }

    @Override
    public List<TaskDto> getTasksByLessonId(Long lessonId) {
        Lesson lesson = lessonService.getLesson(lessonId);
        List<Task> tasks = taskRepository.findByLesson(lesson);
        return tasks.stream().map(taskMapper::toTaskDto).collect(Collectors.toList());
    }

    @Override
    public List<TaskDto> getTasksByTypeId(Long typeId) {
        return taskRepository.findByTypeId(typeId)
                .stream()
                .map(taskMapper::toTaskDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<TaskDto> getActiveTasks() {
        return taskRepository.findByActiveTrue()
                .stream()
                .map(taskMapper::toTaskDto)
                .collect(Collectors.toList());
    }
}
