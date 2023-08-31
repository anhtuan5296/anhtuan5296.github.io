package com.example.kiemtra.service;

import com.example.kiemtra.dto.UserDto;
import com.example.kiemtra.request.AvatarRequest;
import com.example.kiemtra.request.PasswordRequest;
import com.example.kiemtra.request.UserRequest;
import com.example.kiemtra.request.UserUpdateRequest;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers(long page, long limit);
    Long getTotalPages(long limit);
    List<UserDto> searchByName(String name);
    UserDto getUserById(long id);

    UserDto addUser(UserRequest userRequest);

    UserDto updateUser(long id, UserUpdateRequest userUpdateRequest);

    boolean deleteUser(long id);

    boolean updateAvatar(long id, AvatarRequest avatarRequest);

    boolean updatePassword(long id, PasswordRequest passwordRequest);

    String resetPassword(long id);
}
