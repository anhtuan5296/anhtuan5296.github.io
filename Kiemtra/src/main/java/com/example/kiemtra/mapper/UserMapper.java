package com.example.kiemtra.mapper;

import com.example.kiemtra.dto.UserDto;
import com.example.kiemtra.model.User;

public class UserMapper {
    public static UserDto convertToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPhone(user.getPhone());
        userDto.setAddress(user.getAddress());
        userDto.setAvatar(user.getAvatar());
        return userDto;
    }
}