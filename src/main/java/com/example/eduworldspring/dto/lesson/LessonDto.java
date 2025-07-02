package com.example.eduworldspring.dto.lesson;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LessonDto {
private Long lessonId;
private String name;
private String description;
private Boolean is_active;
private String start_date;
private String end_date;


}
