package com.example.eduworldspring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long taskId;

    @ManyToOne
    @JoinColumn(name = "lesson_id", referencedColumnName = "lesson_id")
    private Lesson lesson;

    // Добавил lessonId для удобства работы с DTO
    private Long lessonId;

    private String question;
    private String start_date;
    private String end_date;
    private boolean isActive;
    private int level;
    private Long typeId;

    public String getCorrectAnswer() {
        return "";
    }
}