package com.api.customer.repositories;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.api.customer.entities.UserEntity;
import com.api.customer.mappers.UserMapper;

@Repository
public class UserRepository {

    @Autowired
    private UserMapper userMapper;

    public Optional<UserEntity> findByEmail(String email) {
        return userMapper.findByEmail(email);
    }

    public Boolean existByEmail(String email) {
        return this.userMapper.findByEmail(email) != null;
    }

    public UserEntity save(UserEntity user) {
        return null;
    }
}
