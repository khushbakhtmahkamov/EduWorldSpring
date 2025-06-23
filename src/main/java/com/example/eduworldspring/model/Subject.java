package com.example.eduworldspring.model;

import com.example.eduworldspring.dto.subject.SubjectCreateUpdateDto;
import com.example.eduworldspring.dto.subject.SubjectDto;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
public class Subject {
    private Long id;
    private String title;
    private String code;
    private Integer credits;
    private String description;

    public Subject(){

    }

    public Subject(Long id, String title, String code, Integer credits, String description) {
        this.id = id;
        this.title = title;
        this.code = code;
        this.credits = credits;
        this.description = description;
    }

    public static Subject toSubject(SubjectCreateUpdateDto subjectCreateUpdateDto) {
        return new Subject(
                ThreadLocalRandom.current().nextLong(),
                subjectCreateUpdateDto.getTitle(),
                subjectCreateUpdateDto.getCode(),
                subjectCreateUpdateDto.getCredits(),
                subjectCreateUpdateDto.getDescription()
        );
    }

    public SubjectDto toSubjectDto(Subject subject){
        return new SubjectDto(
                subject.getId(),
                subject.getTitle(),
                subject.getCode(),
                subject.getCredits(),
                subject.getDescription()
        );
    }
}