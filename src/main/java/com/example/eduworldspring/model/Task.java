package com.example.eduworldspring.model;

import com.example.eduworldspring.model.Lesson;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

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

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson_id", nullable = false)
    @NotNull(message = "Lesson cannot be null")
    private Lesson lesson;

    @NotNull(message = "Question cannot be null")
    @Size(min = 1, max = 500, message = "Question must be between 1 and 500 characters")
    private String question;

    private LocalDate startDate;

    private LocalDate endDate;

    private boolean active;

    @Enumerated(EnumType.STRING)
    @Column(name = "level")
    @NotNull(message = "Task level cannot be null")
    private TaskLevel level;

    private Long typeId;

    public String getCorrectAnswer() {
        return "";
    }
}
