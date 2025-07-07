package com.example.eduworldspring.controller;

import com.example.eduworldspring.model.Role;
import com.example.eduworldspring.service.RoleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
    private RoleService roleService;
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public void createRole(@RequestBody Role role) {
        roleService.createRole(role);
    }

    @GetMapping({"/{id}"})
    public Role getRoleById(@PathVariable Long id) {
        return roleService.getById(id);
    }

    @DeleteMapping({"/{id}"})
    public boolean deleteRoleById(@PathVariable Long id) {
        return roleService.deleteById(id);
    }

}
