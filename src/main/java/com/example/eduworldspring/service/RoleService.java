package com.example.eduworldspring.service;

import com.example.eduworldspring.dto.role.*;
import com.example.eduworldspring.model.Role;

import java.util.List;

public interface RoleService {
    List<RoleDto> getAllRoles();
    RoleDto getById(Long id);
    RoleDto createRole(RoleCreateDto dto);
    RoleDto updateRole(Long id, RoleUpdateDto dto);
    Role getEntityById(Long id);
    void deleteRole(Long id);
}
