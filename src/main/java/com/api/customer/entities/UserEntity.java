package com.api.customer.entities;

import lombok.Data;

@Data
public class UserEntity {
    private int userId;
    private String username;
    private String email;
    private String imageUrl;
    private Boolean emailVerified = false;
    private String password;
}
