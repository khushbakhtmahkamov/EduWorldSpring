package com.example.eduworldspring.controller;

import com.example.eduworldspring.mapper.RoleMapper;
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

    @Autowired
    private RoleMapper roleMapper;

    @GetMapping
    public List<RoleDto> getAllRoles() {
        List<Role> roles = roleService.getAllRoles();
        List<RoleDto> res = new ArrayList<>();

        for (Role role : roles) {
            res.add(roleMapper.toDto(role));
        }

        return res;
    }

    @PostMapping
    public Role createRole(@RequestBody RoleCreateDto dto) {
        return roleService.createRole(roleMapper.toModel(dto));
    }

    @GetMapping("/{id}")
    public RoleDto getRoleById(@PathVariable Long id) {
        return roleMapper.toDto(roleService.getById(id));
    }

    @PutMapping("/{id}")
    public Role updateRole(@PathVariable Long id, @RequestBody RoleUpdateDto dto) {
        return roleService.updateRole(id, roleMapper.toModel(id, dto));
    }

    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
    }
}
