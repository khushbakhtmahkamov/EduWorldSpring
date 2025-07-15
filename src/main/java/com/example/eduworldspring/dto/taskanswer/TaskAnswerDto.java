package com.example.eduworldspring.dto.taskanswer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
public class TaskAnswerDto {
    private Long id;
    private Long userId;
    private Long taskId;
    private String answer;
    private Boolean isCorrect;
    private Timestamp answerAt;
}
