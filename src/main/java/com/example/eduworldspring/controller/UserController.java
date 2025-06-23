package com.example.eduworldspring.controller;

import com.example.eduworldspring.dto.user.UserCreateDto;
import com.example.eduworldspring.model.User;
import com.example.eduworldspring.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<User> getAllUsers() {
        return userService.getUsers();
    }
    @PostMapping
    public UserCreateDto createUser(@RequestBody UserCreateDto userCreateDto) {
        userService.addUser(userCreateDto);
        return userCreateDto;
    }

}
