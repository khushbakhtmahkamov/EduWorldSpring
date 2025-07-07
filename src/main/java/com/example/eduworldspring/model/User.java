package com.example.eduworldspring.model;

import com.example.eduworldspring.dto.user.UserCreateDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String email;
    private String password;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
