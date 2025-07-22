package com.example.eduworldspring.repository;

import com.example.eduworldspring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByLanguageId(Long languageId);
    List<User> findAllByRoleId(Long roleId);
    Optional<User> findByEmail(String email);
}
