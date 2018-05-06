package com.health.health.security.services;


import com.health.health.security.models.UserRole;
import com.health.health.security.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    public void save(UserRole role) {
        userRoleRepository.save(role);
    }


}
