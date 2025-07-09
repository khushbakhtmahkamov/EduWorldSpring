package com.example.eduworldspring.service;


import com.example.eduworldspring.dto.role.RoleDto;
import com.example.eduworldspring.dto.user.UserCreateDto;
import com.example.eduworldspring.exceptions.BusinessExceptionCode;
import com.example.eduworldspring.exceptions.BusinessRuntimeException;
import com.example.eduworldspring.mapper.UserMapper;
import com.example.eduworldspring.model.Language;
import com.example.eduworldspring.model.Role;
import com.example.eduworldspring.model.User;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final RoleService roleService;
    private final LanguageService languageService;
    private final UserMapper userMapper;


    private List<User> users = new ArrayList<>();
    @Override
    public void addUser(UserCreateDto userCreateDto) {
        Role role = roleService.getEntityById(userCreateDto.getRoleId());
        if(role == null) {
            throw new BusinessRuntimeException(BusinessExceptionCode.NOT_FOUND,"Role not found with id: " + userCreateDto.getRoleId());
        }
        Language language = languageService.getById(userCreateDto.getLanguageId());
        if(language == null) {
            throw new BusinessRuntimeException(BusinessExceptionCode.NOT_FOUND, "Language not found with id: " + userCreateDto.getLanguageId());
        }

        Long id = ThreadLocalRandom.current().nextLong(1,100);
        User user= userMapper.toUser(userCreateDto, id,  language, role);
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
