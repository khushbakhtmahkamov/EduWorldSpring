package com.example.eduworldspring.mapper;

import com.example.eduworldspring.dto.user.UserCreateDto;
import com.example.eduworldspring.dto.user.UserResponseDto;
import com.example.eduworldspring.model.Language;
import com.example.eduworldspring.model.Role;
import com.example.eduworldspring.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "userCreateDto.name")
    @Mapping(target = "age", source = "userCreateDto.age")
    @Mapping(target = "email", source = "userCreateDto.email")
    @Mapping(target = "password", source = "userCreateDto.password")
    @Mapping(target = "language", source = "language")
    @Mapping(target = "role", source = "role")
    User toUser(UserCreateDto userCreateDto, Language language, Role role);

    @Mapping(target = "languageId", source = "language.id")
    @Mapping(target = "roleId", source = "role.id")
    UserResponseDto toUserResponseDto(User user);
}