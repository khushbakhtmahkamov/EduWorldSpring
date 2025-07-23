package com.example.eduworldspring.controller;

import com.example.eduworldspring.dto.user.UserCreateDto;
import com.example.eduworldspring.dto.user.UserResponseDto;
import com.example.eduworldspring.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserResponseDto> getAllUsers() {
        return userService.getUsers();
    }
    @PostMapping
    public UserResponseDto createUser(@RequestBody UserCreateDto userCreateDto) {
        return userService.addUser(userCreateDto);
    }

    @GetMapping("/{id}")
    public UserResponseDto getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @GetMapping("/by-language/{id}")
    public List<UserResponseDto> getByLanguageId(@PathVariable long id) {
        return userService.getUsersByLanguageId(id);
    }

    @GetMapping("/by-role/{id}")
    public List<UserResponseDto> getByRoleId(@PathVariable long id) {
        return userService.getUsersByRoleId(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
    }
}
