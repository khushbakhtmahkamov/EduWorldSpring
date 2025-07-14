package com.example.eduworldspring.service;

import com.example.eduworldspring.dto.taskanswer.TaskAnswerDto;
import com.example.eduworldspring.dto.taskanswer.TaskAnswerRequestDto;
import com.example.eduworldspring.model.TaskAnswer;

import java.util.List;

public interface TaskAnswerService {
    TaskAnswerDto saveAnswer(TaskAnswerRequestDto dto);
    List<TaskAnswerDto> getAllByUserId(Long userId);
    List<TaskAnswerDto> getAllByTaskId(Long taskId);
}

