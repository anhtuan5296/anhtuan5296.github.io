package com.example.kiemtra.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private long id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String avatar;
    private String password;


    public User(long id, String name, String email, String phone, String address, String password) {
        this.id=id;
        this.name=name;
        this.email=email;
        this.phone=phone;
        this.address=address;
        this.password=password;
    }
}
