package com.health.health.security.repositories;

import com.health.health.security.enums.Role;
import com.health.health.security.models.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rpwk5242 on 3/27/2017.
 */

@Repository
public interface UserRoleRepository extends CrudRepository<UserRole, String> {

    UserRole findByName(Role roleName);
}
