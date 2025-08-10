package com.example.eduworldspring.service;

import com.example.eduworldspring.dto.task.TaskCreateDto;
import com.example.eduworldspring.dto.task.TaskDto;
import com.example.eduworldspring.exceptions.BusinessExceptionCode;
import com.example.eduworldspring.exceptions.BusinessRuntimeException;
import com.example.eduworldspring.mapper.TaskMapper;
import com.example.eduworldspring.model.Lesson;
import com.example.eduworldspring.model.Task;
import com.example.eduworldspring.model.TaskLevel;
import com.example.eduworldspring.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
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
        if (Objects.isNull(taskCreateDto)) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "TaskCreateDto cannot be null");
        }
        if (taskCreateDto.getEndDate() != null && taskCreateDto.getStartDate() != null &&
                taskCreateDto.getEndDate().isBefore(taskCreateDto.getStartDate())) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "End date cannot be before start date");
        }
        Task task = taskMapper.toTask(taskCreateDto, lessonService);
        try {
            return taskMapper.toTaskDto(taskRepository.save(task));
        } catch (Exception e) {
            throw new BusinessRuntimeException(BusinessExceptionCode.COULD_NOT_SAVE, "Failed to save task: " + e.getMessage());
        }
    }

    @Override
    public TaskDto getTaskById(Long taskId) {
        if (Objects.isNull(taskId)) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "Task ID cannot be null");
        }
        return taskRepository.findById(taskId)
                .map(taskMapper::toTaskDto)
                .orElseThrow(() -> new BusinessRuntimeException(BusinessExceptionCode.NOT_FOUND, "Task not found with id: " + taskId));
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
        if (Objects.isNull(id)) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "Task ID cannot be null");
        }
        if (Objects.isNull(taskCreateDto)) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "TaskCreateDto cannot be null");
        }
        if (taskCreateDto.getEndDate() != null && taskCreateDto.getStartDate() != null &&
                taskCreateDto.getEndDate().isBefore(taskCreateDto.getStartDate())) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "End date cannot be before start date");
        }
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new BusinessRuntimeException(BusinessExceptionCode.NOT_FOUND, "Task not found with id: " + id));
        Task updatedTask = taskMapper.toTask(taskCreateDto, lessonService);
        updatedTask.setId(task.getId());
        try {
            return taskMapper.toTaskDto(taskRepository.save(updatedTask));
        } catch (Exception e) {
            throw new BusinessRuntimeException(BusinessExceptionCode.COULD_NOT_UPDATE, "Failed to update task: " + e.getMessage());
        }
    }

    @Override
    public Boolean deleteTask(Long taskId) {
        if (Objects.isNull(taskId)) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "Task ID cannot be null");
        }
        if (!taskRepository.existsById(taskId)) {
            throw new BusinessRuntimeException(BusinessExceptionCode.NOT_FOUND, "Task not found with id: " + taskId);
        }
        try {
            taskRepository.deleteById(taskId);
            return true;
        } catch (Exception e) {
            throw new BusinessRuntimeException(BusinessExceptionCode.COULD_NOT_DELETE, "Failed to delete task: " + e.getMessage());
        }
    }

    @Override
    public List<TaskDto> getTasksByLessonId(Long lessonId) {
        if (Objects.isNull(lessonId)) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "Lesson ID cannot be null");
        }
        Lesson lesson = lessonService.getLesson(lessonId);
        List<Task> tasks = taskRepository.findByLesson(lesson);
        return tasks.stream().map(taskMapper::toTaskDto).collect(Collectors.toList());
    }

    @Override
    public List<TaskDto> getTasksByTypeId(Long typeId) {
        if (Objects.isNull(typeId)) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "Type ID cannot be null");
        }
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

    @Override
    public List<TaskDto> getTasksByDateRange(LocalDate startDate, LocalDate endDate) {
        if (Objects.isNull(startDate) || Objects.isNull(endDate)) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "Start date and end date cannot be null");
        }
        if (endDate.isBefore(startDate)) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "End date cannot be before start date");
        }
        return taskRepository.findByDateRange(startDate, endDate)
                .stream()
                .map(taskMapper::toTaskDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<TaskDto> getTasksByLevel(TaskLevel level) {
        if (Objects.isNull(level)) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "Task level cannot be null");
        }
        return taskRepository.findByLevel(level)
                .stream()
                .map(taskMapper::toTaskDto)
                .collect(Collectors.toList());
    }
}