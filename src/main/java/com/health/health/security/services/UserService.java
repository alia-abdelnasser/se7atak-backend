package com.health.health.security.services;


import com.health.health.security.dtos.UserAuthorityDTO;
import com.health.health.security.enums.Role;
import com.health.health.security.models.User;
import com.health.health.security.models.UserRole;
import com.health.health.security.repositories.UserRepository;
import com.health.health.security.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;


@Service
public class UserService {

    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void save(List<UserAuthorityDTO> usersDTO) {

        List<User> usersList = new LinkedList<User>();
        for (UserAuthorityDTO userAuthorityDTO : usersDTO) {
            // TODO invalid roles
            UserRole role = userRoleRepository.findByName(Role.value(userAuthorityDTO.getRole()));
            if (role != null) {
                if (userAuthorityDTO.getPassword() == null) {
                    userAuthorityDTO.setPassword("default");
                }
                userAuthorityDTO.setPassword(passwordEncoder.encode(userAuthorityDTO.getPassword()));
                usersList.add(userAuthorityDTO.convertToUser(role));
            }
        }

        userRepository.save(usersList);
    }

    public Iterable<User> findAll() {

        return userRepository.findAll();
    }


    public void removeToken(String token, String refreshToken) {
        OAuth2AccessToken ouOAuth2AccessToken = tokenStore.readAccessToken(token);
        OAuth2RefreshToken oAuth2RefreshToken = tokenStore.readRefreshToken(refreshToken);
        if (ouOAuth2AccessToken != null)
            tokenStore.removeAccessToken(ouOAuth2AccessToken);
        if (oAuth2RefreshToken != null)
            tokenStore.removeRefreshToken(oAuth2RefreshToken);
    }
}
