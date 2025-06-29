package com.example.eduworldspring.service;

import com.example.eduworldspring.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();
    Role getById(Long id);
    Role createRole(Role role);
    Role updateRole(Long id, Role role);
    void deleteRole(Long id);
}
