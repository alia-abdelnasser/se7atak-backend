package com.health.health.security.controllers;


import com.health.health.security.dtos.UserAuthorityDTO;
import com.health.health.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

/**
 * Created by rpwk5242 on 3/26/2017.
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;


    // get user to test token validation
    @RequestMapping("/user")
    public Principal getUseInfo(Principal user) {
        return user;
    }

    /*
        Create a multiple users
        if there is a user without a password we set the default password "default"
     */
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<String> createUsers(@RequestBody List<UserAuthorityDTO> userAuthorityDTOs) {


        userService.save(userAuthorityDTOs);

        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @RequestMapping(value = "/logout/{token}/{refreshToken}", method = RequestMethod.POST)
    public ResponseEntity logout(@PathVariable String token, @PathVariable String refreshToken) {
        userService.removeToken(token, refreshToken);
        return new ResponseEntity("User logged out", HttpStatus.OK);
    }
}
