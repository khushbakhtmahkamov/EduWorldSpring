package com.example.eduworldspring.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateDto {
    private String name;
    private int age;
    private String email;
    private String password;
    private Long languageId;
    private Long roleId;
}
