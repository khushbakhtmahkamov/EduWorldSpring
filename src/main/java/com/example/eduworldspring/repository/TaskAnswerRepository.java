package com.example.eduworldspring.repository;

import com.example.eduworldspring.model.TaskAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TaskAnswerRepository extends JpaRepository<TaskAnswer, Long> {
    List<TaskAnswer> findAllByUserId(Long userId);
    List<TaskAnswer> findAllByTaskId(Long taskId);
}
