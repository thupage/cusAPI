package com.api.customer.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.api.customer.entities.UserEntity;
import com.api.customer.mappers.UserMapper;

@Repository
public class UserRepository {

    @Autowired
    private UserMapper userMapper;

    public UserEntity findByEmail(String email) {
        return userMapper.findByEmail(email);
    }

    public void save(UserEntity user) {
    }
}
