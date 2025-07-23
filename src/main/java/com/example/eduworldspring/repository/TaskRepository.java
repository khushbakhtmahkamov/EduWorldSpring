package com.example.eduworldspring.repository;

import com.example.eduworldspring.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
