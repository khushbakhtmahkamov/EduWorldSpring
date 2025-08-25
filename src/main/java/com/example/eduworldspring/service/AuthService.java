package com.example.eduworldspring.service;

import com.example.eduworldspring.dto.auth.ChangePasswordRequest;

public interface AuthService {
    void changePassword(ChangePasswordRequest changePasswordRequest);
    void logout(String email);
}
