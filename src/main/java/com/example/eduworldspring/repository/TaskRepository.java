package com.example.eduworldspring.repository;

import com.example.eduworldspring.model.Lesson;
import com.example.eduworldspring.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT t FROM Task t JOIN FETCH t.lesson WHERE t.lesson = :lesson")
    List<Task> findByLesson(@Param("lesson") Lesson lesson); // Finds all tasks associated with the given Lesson, eagerly fetching the Lesson entity
    List<Task> findByTypeId(Long typeId); // Finds all tasks with the specified type ID
    List<Task> findByActiveTrue(); // Finds all tasks that are marked as active
}