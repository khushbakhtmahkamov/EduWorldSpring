package com.example.eduworldspring.dto.taskanswer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TaskAnswerRequestDto {
    private Long userId;
    private Long taskId;
    private String answer;
}
