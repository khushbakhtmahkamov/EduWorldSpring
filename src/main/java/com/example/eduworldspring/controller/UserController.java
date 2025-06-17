package com.example.eduworldspring.controller;

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
    public User createUser(@RequestBody User user) {
        userService.addUser(user);
        return user;
    }

}
