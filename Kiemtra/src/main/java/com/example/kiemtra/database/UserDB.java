package com.example.kiemtra.database;

import com.example.kiemtra.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDB {
    public static List<User> userList = new ArrayList<>(List.of(
            new User(1, "Nguyen Van A", "abcxyz@gmail.com", "0999999999", "Ha Noi" ,"avatar 1","123456"),
            new User(2, "Nguyen Van B", "abcxyz@gmail.com", "0999999999", "Ha Noi" ,"avatar 1","123456"),
            new User(3, "Nguyen Van C", "abcxyz@gmail.com", "0999999999", "Ha Noi" ,"avatar 1","123456"),
            new User(4, "Nguyen Van D", "abcxyz@gmail.com", "0999999999", "Ha Noi" ,"avatar 1","123456"),
            new User(5, "Nguyen Van E", "abcxyz@gmail.com", "0999999999", "Ha Noi" ,"avatar 1","123456"),
            new User(6, "Nguyen Van F", "abcxyz@gmail.com", "0999999999", "Ha Noi" ,"avatar 1","123456"),
            new User(7, "Nguyen Van F", "abcxyz@gmail.com", "0999999999", "Ha Noi" ,"avatar 1","123456")

    ));
}
