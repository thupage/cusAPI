package com.api.customer.entities;

import lombok.Data;

@Data
public class UserEntity {
    private int id;
    private String email;
    private String imageUrl;
    private String name;
    private String password;
}
