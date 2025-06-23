package com.example.eduworldspring.service;


import com.example.eduworldspring.dto.user.UserCreateDto;
import com.example.eduworldspring.model.Language;
import com.example.eduworldspring.model.Role;
import com.example.eduworldspring.model.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private RoleService roleService;
    private LanguageService languageService;

    public UserServiceImpl(RoleService roleService, LanguageService languageService) {
        this.roleService = roleService;
        this.languageService = languageService;
    }

    private List<User> users = new ArrayList<>();
    @Override
    public void addUser(UserCreateDto userCreateDto) {
        Role role = roleService.getById(userCreateDto.getRoleId());
        if(role == null) {
            throw new IllegalArgumentException("Role not found with id: " + userCreateDto.getRoleId());
        }
        Language language = languageService.getById(userCreateDto.getLanguageId());
        if(language == null) {
            throw new IllegalArgumentException("Language not found with id: " + userCreateDto.getLanguageId());
        }

        User user = new User();
        user= user.createUser(userCreateDto, language, role);
        if(user != null && user.getName() != null) {
            users.add(user);
        }
    }

    @Override
    public boolean removeUserByName(String name) {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getName().equalsIgnoreCase(name)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public User getByName(String name) {
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getUsers() {
        return new ArrayList<>(users);
    }

    @Override
    public List<User> getUsersByLanguage(Language language) {
        List<User> filteredUsers = new ArrayList<>();
        for (User user : users) {
            if (user.getLanguage() != null && user.getLanguage().equals(language)) {
                filteredUsers.add(user);
            }
        }
        return filteredUsers;
    }

    @Override
    public List<User> getByRole(Role role) {
        List<User> filteredUsers = new ArrayList<>();
        for (User user : users) {
            if (user.getRole() != null && user.getRole().equals(role)) {
                filteredUsers.add(user);
            }
        }
        return filteredUsers;
    }
}
