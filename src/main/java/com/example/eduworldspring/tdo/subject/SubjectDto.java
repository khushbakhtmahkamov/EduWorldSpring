package com.example.eduworldspring.tdo.subject;

public class SubjectDto {
    private Long id;
    private String title;
    private String code;
    private Integer credits;
    private String description;

    public SubjectDto(Long id, String title, String code, Integer credits, String description) {
        this.id = id;
        this.title = title;
        this.code = code;
        this.credits = credits;
        this.description = description;
    }
}
