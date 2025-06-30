package com.example.eduworldspring.mapper;

import com.example.eduworldspring.dto.user.UserCreateDto;
import com.example.eduworldspring.model.Language;
import com.example.eduworldspring.model.Role;
import com.example.eduworldspring.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target= "id", source = "id")
    @Mapping(target = "name", source = "userCreateDto.name")
    User toUser(UserCreateDto userCreateDto, Long id, Language language, Role role);

    @Mapping(target = "languageId", source = "language.id")
    @Mapping(target = "roleId", source = "role.id")
    UserCreateDto toUserCreateDto(User user);
}
