package com.example.eduworldspring.service;


import com.example.eduworldspring.dto.user.UserCreateDto;
import com.example.eduworldspring.dto.user.UserResponseDto;
import com.example.eduworldspring.exceptions.BusinessExceptionCode;
import com.example.eduworldspring.exceptions.BusinessRuntimeException;
import com.example.eduworldspring.mapper.UserMapper;
import com.example.eduworldspring.model.Language;
import com.example.eduworldspring.model.Role;
import com.example.eduworldspring.model.User;
import com.example.eduworldspring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final LanguageService languageService;
    private final UserMapper userMapper;

    @Override
    public UserResponseDto addUser(UserCreateDto userCreateDto) {
        Role role = roleService.getEntityById(userCreateDto.getRoleId());
        Language language = languageService.getById(userCreateDto.getLanguageId());

        User user = userMapper.toUser(userCreateDto, language, role);

        if (userRepository.findByEmail(userCreateDto.getEmail()).isPresent()) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "Email address already in use");
        }

        userRepository.save(user);
        return userMapper.toUserResponseDto(user);
    }

    @Override
    public void deleteUser(Long id) {
        if (id == null) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "id cannot be null");
        }

        if (!userRepository.existsById(id)) {
            throw new BusinessRuntimeException(BusinessExceptionCode.NOT_FOUND, "user with id " + id + " not found");
        }
        userRepository.deleteById(id);
    }

    @Override
    public UserResponseDto getUser(Long id) {
        if (id == null) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "id cannot be null");
        }

        User user = userRepository.findById(id).orElseThrow(() ->
                new BusinessRuntimeException(BusinessExceptionCode.NOT_FOUND, "Subject with id " + id + " not found")
        );

        return userMapper.toUserResponseDto(user);
    }

    @Override
    public List<UserResponseDto> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toUserResponseDto)
                .toList();
    }

    @Override
    public List<UserResponseDto> getUsersByLanguageId(Long id) {
        if (id == null) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "id cannot be null");
        }

        return userRepository.findAllByLanguageId(id)
                .stream()
                .map(userMapper::toUserResponseDto)
                .toList();
    }

    @Override
    public List<UserResponseDto> getUsersByRoleId(Long id) {
        if (id == null) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "id cannot be null");
        }

        return userRepository.findAllByRoleId(id)
                .stream()
                .map(userMapper::toUserResponseDto)
                .toList();
    }
}
