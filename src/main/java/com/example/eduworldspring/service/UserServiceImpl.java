package com.example.eduworldspring.service;

import com.example.eduworldspring.dto.user.UserCreateDto;
import com.example.eduworldspring.dto.user.UserResponseDto;
import com.example.eduworldspring.exceptions.BusinessExceptionCode;
import com.example.eduworldspring.exceptions.BusinessRuntimeException;
import com.example.eduworldspring.mapper.UserMapper;
import com.example.eduworldspring.model.Language;
import com.example.eduworldspring.model.Role;
import com.example.eduworldspring.model.User;
import com.example.eduworldspring.model.UserStatus;
import com.example.eduworldspring.repository.LanguageRepository;
import com.example.eduworldspring.repository.RoleRepository;
import com.example.eduworldspring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final LanguageRepository languageRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponseDto addUser(UserCreateDto userCreateDto) {
        Role role = roleRepository.findById(userCreateDto.getRoleId())
                .orElseThrow(() -> new BusinessRuntimeException(
                        BusinessExceptionCode.NOT_FOUND,
                        "role with id " + userCreateDto.getRoleId() + " not found"
                ));

        Language language = languageRepository.findById(userCreateDto.getLanguageId())
                .orElseThrow(() -> new BusinessRuntimeException(
                        BusinessExceptionCode.NOT_FOUND,
                        "language with id " + userCreateDto.getLanguageId() + " not found"
                ));

        User user = userMapper.toUser(userCreateDto, language, role);
        user.setStatus(UserStatus.ACTIVE);

        if (userRepository.findByEmailIgnoreCase(userCreateDto.getEmail()).isPresent()) {
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

        User user = userRepository.findById(id).orElseThrow(() ->
                new BusinessRuntimeException(BusinessExceptionCode.NOT_FOUND, "user with id " + id + " not found"));

        user.setStatus(UserStatus.DELETED);
        user.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        userRepository.save(user);
    }

    @Override
    public UserResponseDto getUser(Long id) {
        if (id == null) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "id cannot be null");
        }

        User user = userRepository.findById(id).orElseThrow(() ->
                new BusinessRuntimeException(BusinessExceptionCode.NOT_FOUND, "Subject with id " + id + " not found")
        );

        if (user.getStatus() == UserStatus.DELETED) {
            throw new BusinessRuntimeException(BusinessExceptionCode.NOT_FOUND, "User with id " + id + " not found");
        }

        return userMapper.toUserResponseDto(user);
    }

    @Override
    public List<UserResponseDto> getUsers() {
        return userRepository.findAllByStatusNot(UserStatus.DELETED)
                .stream()
                .map(userMapper::toUserResponseDto)
                .toList();
    }

    @Override
    public List<UserResponseDto> getUsersByLanguageId(Long id) {
        if (id == null) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "id cannot be null");
        }

        return userRepository.findAllByLanguageIdAndStatusNot(id, UserStatus.DELETED)
                .stream()
                .map(userMapper::toUserResponseDto)
                .toList();
    }

    @Override
    public List<UserResponseDto> getUsersByRoleId(Long id) {
        if (id == null) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "id cannot be null");
        }

        return userRepository.findAllByRoleIdAndStatusNot(id, UserStatus.DELETED)
                .stream()
                .map(userMapper::toUserResponseDto)
                .toList();
    }

    @Override
    public void updateUser(Long id, UserCreateDto userCreateDto) {
        if (id == null) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "id cannot be null");
        }

        User user = userRepository.findById(id).orElseThrow(() ->
                new BusinessRuntimeException(BusinessExceptionCode.NOT_FOUND,
                        "user with id " + id + " not found"));

        Role role = roleRepository.findById(userCreateDto.getRoleId()).orElseThrow(() ->
                new BusinessRuntimeException(BusinessExceptionCode.NOT_FOUND,
                        "role woth id " + userCreateDto.getRoleId() + " not found"));

        Language language = languageRepository.findById(userCreateDto.getLanguageId()).orElseThrow(() ->
                new BusinessRuntimeException(BusinessExceptionCode.NOT_FOUND,
                        "language with id " + userCreateDto.getLanguageId() + " not found"));

        userMapper.updateUserFromDto(userCreateDto, language, role, user);
        user.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        userRepository.save(user);
    }

    @Override
    public ResponseEntity<String> logoutCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
            return ResponseEntity.status(401).body("Пользователь не авторизован");
        }

        String email = authentication.getName();
        User user = userRepository.findByEmailIgnoreCase(email)
                .orElseThrow(() -> new RuntimeException("Пользователь не найден"));

        user.setTokenExpiredAt(new Timestamp(System.currentTimeMillis()));
        userRepository.save(user);

        return ResponseEntity.ok("Вы успешно вышли из системы");
    }
}