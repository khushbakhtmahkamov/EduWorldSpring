package com.example.eduworldspring.repository;

import com.example.eduworldspring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
