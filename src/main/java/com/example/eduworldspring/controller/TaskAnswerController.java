package com.example.eduworldspring.controller;

import com.example.eduworldspring.dto.taskanswer.TaskAnswerDto;
import com.example.eduworldspring.dto.taskanswer.TaskAnswerRequestDto;
import com.example.eduworldspring.service.TaskAnswerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task-answers")
@RequiredArgsConstructor
public class TaskAnswerController {

    private final TaskAnswerServiceImpl taskAnswerService;

    @PostMapping
    public TaskAnswerDto saveAnswer(@RequestBody TaskAnswerRequestDto dto) {
        return taskAnswerService.saveAnswer(dto);
    }

    @GetMapping("/user/{userId}")
    public List<TaskAnswerDto> getAllByUserId(@PathVariable Long userId) {
        return taskAnswerService.getAllByUserId(userId);
    }

    @GetMapping("/task/{taskId}")
    public List<TaskAnswerDto> getAllByTaskId(@PathVariable Long taskId) {
        return taskAnswerService.getAllByTaskId(taskId);
    }
}
