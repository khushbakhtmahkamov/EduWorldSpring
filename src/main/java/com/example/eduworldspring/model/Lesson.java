package com.example.eduworldspring.model;

import jakarta.persistence.*;
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
@Table(name = "lessons")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Boolean is_active;
    private LocalDate start_date;
    private LocalDate end_date;

    @Column(name = "teacher_id")
    private Long teacher_id;

    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id", insertable = false, updatable = false)
    private User teacher;

    @Column(name = "subject_id")
    private Long subject_id;

    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Subject subject;
}
