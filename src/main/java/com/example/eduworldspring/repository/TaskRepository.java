package com.example.eduworldspring.repository;

import com.example.eduworldspring.model.Task;
import com.example.eduworldspring.model.Lesson;
import com.example.eduworldspring.model.TaskLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT t FROM Task t JOIN FETCH t.lesson WHERE t.lesson = :lesson")
    List<Task> findByLesson(@Param("lesson") Lesson lesson);

    List<Task> findByTypeId(Long typeId);

    List<Task> findByLevel(TaskLevel level);

    List<Task> findByActiveTrue();

    @Query("SELECT t FROM Task t WHERE t.startDate >= :startDate AND t.endDate <= :endDate")
    List<Task> findByDateRange(@Param("startDate") LocalDate startDate,
                               @Param("endDate") LocalDate endDate);
}
