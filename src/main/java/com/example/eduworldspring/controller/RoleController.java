package com.example.eduworldspring.controller;

import com.example.eduworldspring.model.Role;
import com.example.eduworldspring.service.RoleService;
import com.example.eduworldspring.dto.role.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public List<RoleDto> getAllRoles() {
        List<Role> roles = roleService.getAllRoles();
        List<RoleDto> result = new ArrayList<>();
        for (Role role : roles) {
            result.add(new RoleDto(role.getName(), role.isActive()));
        }
        return result;
    }

    @PostMapping
    public Role createRole(@RequestBody RoleCreateDto dto) {
        Role role = new Role(null, dto.getName(), dto.getDescription(), dto.isActive());
        return roleService.createRole(role);
    }

    @GetMapping("/{id}")
    public RoleDto getRoleById(@PathVariable Long id) {
        Role role = roleService.getRoleById(id);
        if (role != null) {
            return new RoleDto(role.getName(), role.isActive());
        }
        return null;
    }

    @PutMapping("/{id}")
    public Role updateRole(@PathVariable Long id, @RequestBody RoleUpdateDto dto) {
        Role roleDetails = new Role(id, dto.getName(), dto.getDescription(), dto.isActive());
        return roleService.updateRole(id, roleDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
    }
}
