package com.example.eduworldspring.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
public class Lesson {
    @Id
    private Long lesson_id;
    private String name;
    private String description;
    private Boolean is_active;
    private String start_date;
    private String end_date;
    private Long subject_id;
    private Long teacher_id;
}
