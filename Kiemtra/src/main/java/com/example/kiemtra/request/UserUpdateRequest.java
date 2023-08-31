package com.example.kiemtra.request;

import lombok.Data;

@Data
public class UserUpdateRequest {
    private String name;
    private String phone;
    private String address;


}