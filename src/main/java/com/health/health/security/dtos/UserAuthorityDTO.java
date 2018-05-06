package com.health.health.security.dtos;


import com.health.health.security.models.User;
import com.health.health.security.models.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAuthorityDTO {
    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;

    public User convertToUser(UserRole role) {
        return new User(this.username, this.password, role);
    }
}
