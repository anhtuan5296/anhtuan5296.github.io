package com.example.kiemtra.dao;

import com.example.kiemtra.model.User;

import java.util.List;

public interface UserDao {
    public List<User> findAll();

    void add(User newUser);
    void setList(List<User> user);
}
