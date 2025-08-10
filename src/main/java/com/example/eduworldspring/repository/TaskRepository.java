package com.example.eduworldspring.repository;

import com.example.eduworldspring.dto.lesson.LessonDto;
import com.example.eduworldspring.model.Task;
import com.example.eduworldspring.model.TaskLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT t FROM Task t JOIN FETCH t.lesson WHERE t.lesson = :lesson")
    List<Task> findByLesson(@Param("lesson") LessonDto lesson);

    List<Task> findByTypeId(Long typeId);

    List<Task> findByActiveTrue();

    @Query("SELECT t FROM Task t WHERE (:startDate IS NULL OR t.startDate >= :startDate) AND (:endDate IS NULL OR t.endDate <= :endDate)")
    List<Task> findByDateRange(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    List<Task> findByLevel(@Param("level") TaskLevel level);
}