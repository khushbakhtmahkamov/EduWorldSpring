package com.example.eduworldspring.service;

import com.example.eduworldspring.model.Role;

public interface RoleService {

    Role getById(Long id);
    void createRole(Role role);
}
