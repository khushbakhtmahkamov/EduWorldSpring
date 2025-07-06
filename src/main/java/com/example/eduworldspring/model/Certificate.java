package com.example.eduworldspring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
public class Certificate {
    private Long id;
    private Subject subject;
    private User user;
    private String title;
    private String description;
    private Boolean isAccess;
    private LocalDateTime issuedAt;
    private Integer progressPercentage;
}