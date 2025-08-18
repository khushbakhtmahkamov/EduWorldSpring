package com.example.eduworldspring.controller;

import com.example.eduworldspring.config.JwtUtil;
import com.example.eduworldspring.dto.auth.AuthRequest;
import com.example.eduworldspring.dto.lesson.LessonCreateUpdateDto;
import com.example.eduworldspring.dto.updatePassword.UpdatePasswordDto;
import com.example.eduworldspring.model.BlackList;
import com.example.eduworldspring.service.BlackListService;
import com.example.eduworldspring.service.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;
    private final BlackListService blackListService;
    private final UserServiceImpl userServiceImpl;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest request) {
        blackListService.deleteTokenByEmail(request.getEmail());
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        UserDetails user = (UserDetails) auth.getPrincipal();
        String token = jwtUtil.generateToken(user);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestHeader("Authorization") String authHeader) {
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            // добавим токен в чёрный список
            BlackList blackList = new BlackList();
            blackList.setName(token);
            blackListService.addToken(blackList);
            return ResponseEntity.ok("You are logout successfully");
        }
        return ResponseEntity.ok("Bad Request");
    }

    @PostMapping("/change-password")
    public ResponseEntity<String> changePassword(@RequestBody UpdatePasswordDto passwordDto) {
        try {
            userServiceImpl.updatePassword(passwordDto.getEmail(), passwordDto.getOldPassword(), passwordDto.getNewPassword());
            return ResponseEntity.ok("Password changed successfully");
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
