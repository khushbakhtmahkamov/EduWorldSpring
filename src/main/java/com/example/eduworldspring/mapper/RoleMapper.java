package com.example.eduworldspring.mapper;

import com.example.eduworldspring.dto.role.RoleCreateDto;
import com.example.eduworldspring.dto.role.RoleDto;
import com.example.eduworldspring.dto.role.RoleUpdateDto;
import com.example.eduworldspring.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleDto toDto(Role role);

    Role toModel(RoleCreateDto dto);

    @Mapping(target = "id", source = "id")
    Role toModel(Long id, RoleUpdateDto dto);
}
