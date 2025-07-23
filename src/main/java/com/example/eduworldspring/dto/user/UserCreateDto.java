package com.example.eduworldspring.dto.user;

import jakarta.validation.constraints.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateDto {
    @NotBlank(message = "Name can't be blank")
    private String name;

    @Min(value = 1, message = "Age must be > 1")
    private int age;

    @NotBlank(message = "Email can't be blank")
    @Email(message = "Incorrect format of email")
    private String email;

    @Size(min = 8, message = "Password must contain at least 8 symbols")
    private String password;

    @NotNull(message = "Language id is required")
    private Long languageId;

    @NotNull(message = "Role id is required")
    private Long roleId;
}
