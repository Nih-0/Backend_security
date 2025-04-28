package com.nihal.securityDB.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.nihal.securityDB.model.users;


@Service
public class loginservice {

    @Autowired
    private AuthenticationManager authManager;
    
    @Autowired
    private JWTservice jwtservice;

    
    public String verify(@RequestBody users user) {
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        if (authentication.isAuthenticated()) {
            return jwtservice.generatetoken(user.getUsername());
        }

        return "failure";
    }
}

