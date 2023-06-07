package com.api.customer.mappers;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.api.customer.entities.UserEntity;

@Mapper
public interface UserMapper {

    public Optional<UserEntity> findByEmail(String username);
    public UserEntity selectByUserName(@Param("username") String username);
}
