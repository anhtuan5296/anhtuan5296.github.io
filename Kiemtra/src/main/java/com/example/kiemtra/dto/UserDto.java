package com.example.kiemtra.dto;

import lombok.Data;

@Data
public class UserDto {
    private long id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String avatar;
}

