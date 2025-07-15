package com.example.eduworldspring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {
    private Long taskId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    private String question;
    private String start_date;
    private String end_date;
    private boolean isActive;
    private int level;
    private Long typeId;
    private Long lessonId;

    public Task () {}

    public String getCorrectAnswer() {
        return "";
    }
}
