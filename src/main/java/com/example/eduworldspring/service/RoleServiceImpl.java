package com.example.eduworldspring.service;

import com.example.eduworldspring.model.Role;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private List<Role> roles = new ArrayList<>();
    private long nextId = 1;

    @Override
    public List<Role> getAllRoles() {
        return new ArrayList<>(roles);
    }

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
    public Role createRole(Role role) {
        role.setId(nextId++);
        roles.add(role);
        return role;
    }

    @Override
    public Role updateRole(Long id, Role roleDetails) {
        for (Role role : roles) {
            if (role.getId().equals(id)) {
                role.setName(roleDetails.getName());
                return role;
            }
        }
        return null;
    }

    @Override
    public void deleteRole(Long id) {
        Iterator<Role> iterator = roles.iterator();
        while (iterator.hasNext()) {
            Role role = iterator.next();
            if (role.getId().equals(id)) {
                iterator.remove();
                break;
            }
        }
    }
}
