package com.example.kiemtra.request;

import lombok.Data;

@Data
public class UserRequest {
    private String name;
    private String email;
    private String phone;
    private String address;
    private String password;
}
