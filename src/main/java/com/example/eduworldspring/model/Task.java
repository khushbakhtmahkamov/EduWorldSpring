package com.example.eduworldspring.model;

import com.example.eduworldspring.model.TaskLevel;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson_id", nullable = false)
    private Lesson lesson;
    private String question;
    private String start_date;
    private String end_date;
    private boolean active;

    @Enumerated(EnumType.STRING)
    @Column(name = "level")
    private TaskLevel level;

    private Long typeId;

    // Метод для получения правильного ответа
    public String getCorrectAnswer() {
        return "";
    }
}
