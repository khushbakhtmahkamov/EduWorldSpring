package com.example.eduworldspring.dto.lesson;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LessonCreateUpdateDto {
    private String name;
    private String description;
    private Boolean is_active;
    private String start_date;
    private String end_date;

}
