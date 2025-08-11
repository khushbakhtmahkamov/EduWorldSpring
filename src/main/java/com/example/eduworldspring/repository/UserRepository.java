package com.example.eduworldspring.repository;

import com.example.eduworldspring.model.User;
import com.example.eduworldspring.model.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    List<User> findAllByLanguageIdAndStatusNot(Long languageId, UserStatus status);
    List<User> findAllByRoleIdAndStatusNot(Long roleId, UserStatus status);
    List<User> findAllByStatusNot(UserStatus status);
}