package com.api.customer.mappers;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.api.customer.entities.UserEntity;

@Mapper
public interface UserMapper {

    public Optional<UserEntity> findByEmail(String email);

}
