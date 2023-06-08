package com.api.customer.mappers;

import org.apache.ibatis.annotations.Mapper;

import com.api.customer.entities.UserEntity;

@Mapper
public interface UserMapper {

    public UserEntity findByEmail(String email);
}
