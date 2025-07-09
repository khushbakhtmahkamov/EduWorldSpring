package com.example.eduworldspring.service;

import com.example.eduworldspring.exceptions.BusinessExceptionCode;
import com.example.eduworldspring.exceptions.BusinessRuntimeException;
import com.example.eduworldspring.model.Category;
import com.example.eduworldspring.model.Role;
import com.example.eduworldspring.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleServiceIml implements RoleService {

    private final RoleRepository roleRepository;
    @Override
    public Role getById(Long id) {
        Role role = roleRepository.findById(id).orElse(null);
        if(role == null) {
            throw new BusinessRuntimeException(BusinessExceptionCode.NOT_FOUND, "Role not found with id: " + id);
        }
        return role;
    }

    @Override
    public void createRole(Role role) {
        if(role == null) {
            throw new IllegalArgumentException("Role cannot be null");
        }
        if(role.getName() == null || role.getName().isEmpty()) {
            throw new IllegalArgumentException("Role name cannot be null or empty");
        }
        roleRepository.save(role);
    }

    @Override
    public boolean deleteById(Long id) {
        Role role = roleRepository.findById(id).orElse(null);
        if(role == null) {
            throw new BusinessRuntimeException(BusinessExceptionCode.NOT_FOUND, "Role not found with id: " + id);
        }
        roleRepository.deleteById(id);
        return true;
    }
}
