package com.example.eduworldspring.tdo.subject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SubjectDto {
    private Long id;
    private String title;
    private String code;
    private Integer credits;
    private String description;
}
