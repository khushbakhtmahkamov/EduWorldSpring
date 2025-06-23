package com.example.eduworldspring.model;

import com.example.eduworldspring.dto.user.UserCreateDto;

import java.util.concurrent.ThreadLocalRandom;

public class User {

    private Long id;
    private String name;
    private int age;
    private String email;
    private String password;

    private Language language;

    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(Long id, String name, int age, String email, String password, Language language, Role role) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
        this.language = language;
        this.role = role;
    }

    public User createUser(UserCreateDto userCreateDto, Language language, Role role) {
        return new User(
                ThreadLocalRandom.current().nextLong(),
                userCreateDto.getName(),
                userCreateDto.getAge(),
                userCreateDto.getEmail(),
                userCreateDto.getPassword(),
                language,
                role
        );
    }
    public User() {
        // Default constructor
    }
}
