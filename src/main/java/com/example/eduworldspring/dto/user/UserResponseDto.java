package com.example.eduworldspring.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {
    private Long id;
    private String name;
    private int age;
    private String email;
    private Long languageId;
    private Long roleId;
}