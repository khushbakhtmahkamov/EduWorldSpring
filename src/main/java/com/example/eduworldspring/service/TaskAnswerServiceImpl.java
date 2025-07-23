package com.example.eduworldspring.service;

import com.example.eduworldspring.dto.taskanswer.TaskAnswerDto;
import com.example.eduworldspring.dto.taskanswer.TaskAnswerRequestDto;
import com.example.eduworldspring.exceptions.BusinessExceptionCode;
import com.example.eduworldspring.exceptions.BusinessRuntimeException;
import com.example.eduworldspring.mapper.TaskAnswerMapper;
import com.example.eduworldspring.model.Task;
import com.example.eduworldspring.model.TaskAnswer;
import com.example.eduworldspring.repository.TaskAnswerRepository;
import com.example.eduworldspring.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskAnswerServiceImpl implements TaskAnswerService {
    private final TaskAnswerRepository taskAnswerRepository;
    private final TaskAnswerMapper taskAnswerMapper;
    private final TaskRepository taskRepository;

    @Override
    public TaskAnswerDto saveAnswer(TaskAnswerRequestDto dto) {
        Task task = taskRepository.findById(dto.getTaskId())
                .orElseThrow(() -> new BusinessRuntimeException(
                        BusinessExceptionCode.NOT_FOUND, "Task with id " + dto.getTaskId() + " not found")
                );


        TaskAnswer taskAnswer = taskAnswerMapper.toModelFromRequest(dto);
        taskAnswer.setTask(task);
        taskAnswer.setAnswerAt(new Timestamp(System.currentTimeMillis()));
        taskAnswer.setIsCorrect(taskAnswer.getAnswer().equals(task.getCorrectAnswer()));

        taskAnswer = taskAnswerRepository.save(taskAnswer);
        return taskAnswerMapper.toDto(taskAnswer);
    }

    @Override
    public List<TaskAnswerDto> getAllByUserId(Long userId) {
        List<TaskAnswer> answers = taskAnswerRepository.findAllByUserId(userId);
        if (answers.isEmpty()) {
            throw new BusinessRuntimeException(
                    BusinessExceptionCode.NOT_FOUND,
                    "No answers found for user with id " + userId
            );
        }
        return answers.stream()
                .map(taskAnswerMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<TaskAnswerDto> getAllByTaskId(Long taskId) {
        List<TaskAnswer> answers = taskAnswerRepository.findAllByTaskId(taskId);
        if (answers.isEmpty()) {
            throw new BusinessRuntimeException(
                    BusinessExceptionCode.NOT_FOUND,
                    "No answers found for task with id " + taskId
            );
        }
        return answers.stream()
                .map(taskAnswerMapper::toDto)
                .collect(Collectors.toList());
    }

}
