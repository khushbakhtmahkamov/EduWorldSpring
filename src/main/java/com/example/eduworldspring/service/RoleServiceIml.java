package com.example.eduworldspring.service;

import com.example.eduworldspring.model.Category;
import com.example.eduworldspring.model.Role;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceIml implements RoleService {

    private List<Role> roles = new ArrayList<>();
    @Override
    public Role getById(Long id) {
        for (Role role : roles) {
            if (role.getId().equals(id)) {
                return role;
            }
        }
        return null;
    }

    @Override
    public void createRole(Role role) {
        if (role != null && role.getName() != null) {
            roles.add(role);
        }
    }
}
