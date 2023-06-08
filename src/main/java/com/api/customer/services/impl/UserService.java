package com.api.customer.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.api.customer.entities.UserEntity;
import com.api.customer.repositories.UserRepository;
import com.api.customer.services.LoginUserService;
import com.api.customer.utils.JwtTokenUtil;

public class UserService implements LoginUserService {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    @Override
    public String signUp(UserEntity user) {
        UserEntity dbUser = userRepository.findByEmail(user.getEmail());
        if (dbUser != null) {
            throw new RuntimeException("User already exist.");
        }
        user.setPassword(bcryptEncoder.encode(user.getPassword()));
        // userRepository.save(user);
        return jwtTokenUtil.generateToken(user);
    }
}
