package com.example.eduworldspring.controller;

import com.example.eduworldspring.dto.user.UserCreateDto;
import com.example.eduworldspring.dto.user.UserResponseDto;
import com.example.eduworldspring.repository.UserRepository;
import com.example.eduworldspring.service.UserService;
import com.example.eduworldspring.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

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
    public List<UserResponseDto> getByLanguageId(@PathVariable Long id) {
        return userService.getUsersByLanguageId(id);
    }

    @GetMapping("/by-role/{id}")
    public List<UserResponseDto> getByRoleId(@PathVariable Long id) {
        return userService.getUsersByRoleId(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PutMapping("/{id}")
    public void updateUser(@RequestBody UserCreateDto userCreateDto, @PathVariable Long id) {
        userService.updateUser(id, userCreateDto);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request) {
        return  userService.logoutCurrentUser();
    }
}
