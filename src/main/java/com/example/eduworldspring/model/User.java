package com.example.eduworldspring.model;

import com.example.eduworldspring.dto.user.UserCreateDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
@AllArgsConstructor
public class User {

    private Long id;
    private String name;
    private int age;
    private String email;
    private String password;

    private Language language;

    private Role role;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
