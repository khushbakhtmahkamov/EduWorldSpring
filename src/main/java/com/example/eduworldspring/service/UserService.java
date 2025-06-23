package com.example.eduworldspring.service;


import com.example.eduworldspring.dto.user.UserCreateDto;
import com.example.eduworldspring.model.Language;
import com.example.eduworldspring.model.Role;
import com.example.eduworldspring.model.User;

import java.util.List;

public interface UserService {
    void addUser(UserCreateDto userCreateDto);

    boolean removeUserByName(String name);

    User getByName(String name);

    List<User> getUsers();

    List<User> getUsersByLanguage(Language language);

    List<User> getByRole(Role role);
}
