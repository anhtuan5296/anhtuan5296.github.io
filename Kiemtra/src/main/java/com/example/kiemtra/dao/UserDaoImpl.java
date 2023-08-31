package com.example.kiemtra.dao;

import com.example.kiemtra.database.UserDB;
import com.example.kiemtra.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{
    @Override
    public List<User> findAll() {
        return UserDB.userList;
    }

    @Override
    public void add(User newUser) {
        UserDB.userList.add(newUser);
    }

    @Override
    public void setList(List<User> user) {
        UserDB.userList=user;
    }
}
