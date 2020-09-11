package com.propscout.teafactory.services;

import com.propscout.teafactory.models.entities.Role;
import com.propscout.teafactory.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RolesService {

    private RoleRepository roleRepository;

    public RolesService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public boolean add(Role role) {

        final Optional<Role> optionalRole = roleRepository.findByTitle(role.getTitle());

        if (optionalRole.isPresent()) {
            return false;
        }

        final Role savedRole = roleRepository.save(role);

        return true;

    }
}
