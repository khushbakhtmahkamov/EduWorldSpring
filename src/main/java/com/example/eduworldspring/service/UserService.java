package com.example.eduworldspring.service;


import com.example.eduworldspring.dto.user.UserCreateDto;
import com.example.eduworldspring.dto.user.UserResponseDto;
import com.example.eduworldspring.model.Language;
import com.example.eduworldspring.model.Role;
import com.example.eduworldspring.model.User;

import java.util.List;

public interface UserService {
    UserResponseDto addUser(UserCreateDto userCreateDto);

    void deleteUser(Long id);

    UserResponseDto getUser(Long id);

    List<UserResponseDto> getUsers();

    List<UserResponseDto> getUsersByLanguageId(Long id);

    List<UserResponseDto> getUsersByRoleId(Long id);

    void updateUser(Long id, UserCreateDto userCreateDto);

    boolean updatePassword(String email, String oldPassword, String newPassword);

}
