package com.example.eduworldspring.service;

import com.example.eduworldspring.dto.auth.ChangePasswordRequest;
import com.example.eduworldspring.exceptions.BusinessExceptionCode;
import com.example.eduworldspring.exceptions.BusinessRuntimeException;
import com.example.eduworldspring.model.User;
import com.example.eduworldspring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void changePassword(ChangePasswordRequest changePasswordRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(changePasswordRequest.getEmail(), changePasswordRequest.getOldPassword())
            );
        } catch (BadCredentialsException ex) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "Неверный старый пароль");
        }

        if (changePasswordRequest.getOldPassword().equals(changePasswordRequest.getNewPassword())) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "Новый пароль не должен совпадать со старым");
        }

        User user = userRepository.findByEmailIgnoreCase(changePasswordRequest.getEmail())
                .orElseThrow(() -> new BusinessRuntimeException(BusinessExceptionCode.NOT_FOUND, "Пользователь не найден"));

        user.setPassword(passwordEncoder.encode(changePasswordRequest.getNewPassword()));

        userRepository.save(user);
    }

    @Override
    public void logout(String email) {
        User user = userRepository.findByEmailIgnoreCase(email)
                .orElseThrow(() -> new BusinessRuntimeException(BusinessExceptionCode.NOT_FOUND, "Пользователь не найден"));
        user.setTokenExpiredAt(new Timestamp(System.currentTimeMillis()));
        userRepository.save(user);
    }
}