package com.example.eduworldspring.service;

import com.example.eduworldspring.dto.role.RoleCreateDto;
import com.example.eduworldspring.dto.role.RoleDto;
import com.example.eduworldspring.dto.role.RoleUpdateDto;
import com.example.eduworldspring.mapper.RoleMapper;
import com.example.eduworldspring.model.Role;
import com.example.eduworldspring.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.eduworldspring.exceptions.BusinessRuntimeException;
import com.example.eduworldspring.exceptions.BusinessExceptionCode;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    private List<Role> roles = new ArrayList<>();

    @Override
    public List<RoleDto> getAllRoles() {
        List<RoleDto> result = new ArrayList<>();
        for (Role role : roles) {
            result.add(roleMapper.toDto(role));
        }
        return result;
    }

    @Override
    public RoleDto getById(Long id) {
        Role role = findByIdOrThrow(id);
        return roleMapper.toDto(role);
    }

    @Override
    public RoleDto createRole(RoleCreateDto dto) {
        Role role = roleMapper.toModel(dto);
        role = roleRepository.save(role);
        return roleMapper.toDto(role);
    }

    @Override
    public RoleDto updateRole(Long id, RoleUpdateDto dto) {
        Role role = findByIdOrThrow(id);
        role.setName(dto.getName());
        role.setDescription(dto.getDescription());
        role.setActive(dto.isActive());
        return roleMapper.toDto(role);
    }

    @Override
    public void deleteRole(Long id) {
        Role role = findByIdOrThrow(id);
        boolean removed = false;
        for (int i = 0; i < roles.size(); i++) {
            if (roles.get(i).getId().equals(id)) {
                roles.remove(i);
                removed = true;
                break;
            }
        }
        if (!removed) {
            throw new BusinessRuntimeException(
                    BusinessExceptionCode.COULD_NOT_DELETE,
                    "Could not delete role with id " + id
            );
        }
    }

    private Role findByIdOrThrow(Long id) {
        Role role = roleRepository.findById(id).orElse(null);
        if (role == null)
            throw new BusinessRuntimeException(
                    BusinessExceptionCode.NOT_FOUND, "Role with id " + id + " not found"
            );

        return role;
    }

    @Override
    public Role getEntityById(Long id) {
        for (Role role : roles) {
            if (role.getId().equals(id)) {
                return role;
            }
        }
        throw new BusinessRuntimeException(
                BusinessExceptionCode.NOT_FOUND,
                "Role with id " + id + " not found"
        );
    }

}
