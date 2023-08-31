package com.example.kiemtra.service;

import com.example.kiemtra.dao.UserDao;
import com.example.kiemtra.dto.UserDto;
import com.example.kiemtra.exception.InvalidOldPasswordException;
import com.example.kiemtra.exception.SamePasswordException;
import com.example.kiemtra.mapper.UserMapper;
import com.example.kiemtra.model.User;
import com.example.kiemtra.request.AvatarRequest;
import com.example.kiemtra.request.PasswordRequest;
import com.example.kiemtra.request.UserRequest;
import com.example.kiemtra.request.UserUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Override
    public List<UserDto> getAllUsers(long page, long limit) {
        return getSubList(userDao.findAll(), page, limit).stream()
                .map(UserMapper::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Long getTotalPages(long limit) {
        long size=userDao.findAll().size();
        System.out.println(size);
        System.out.println(limit);
        if(size<=limit){
            return 1l;
        }
        return (long) Math.ceil(size*1.0 / limit);
    }

    public static <T> List<T> getSubList(List<T> originalList, long page, long limit) {
        int startIdx = (int) Math.min(page, originalList.size());
        int endIdx = (int) Math.min(limit, originalList.size());
        return originalList.subList(startIdx-1, endIdx);
    }

    public List<UserDto> searchByName(String name) {
        List<UserDto> filteredUsers = userDao.findAll().stream()
                .filter(user -> user.getName().toLowerCase().contains(name.toLowerCase()))
                .map(UserMapper::convertToDto)
                .collect(Collectors.toList());
        return filteredUsers;
    }

    @Override
    public UserDto getUserById(long id) {
        User user = userDao.findAll().stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElse(null);
        if (user != null) {
            return UserMapper.convertToDto(user);
        } else {
            return null;
        }
    }

    @Override
    public UserDto addUser(UserRequest userRequest) {
        long newUserId = generateUniqueRandomId();
        User newUser = new User(newUserId, userRequest.getName(), userRequest.getEmail(), userRequest.getPhone(), userRequest.getAddress(), userRequest.getPassword());
        userDao.add(newUser);
        return UserMapper.convertToDto(newUser);
    }

    @Override
    public UserDto updateUser(long id, UserUpdateRequest userUpdateRequest) {
        User userToUpdate=null;
        for (User user : userDao.findAll()) {
            if (user.getId() == id) {
                user.setName(userUpdateRequest.getName());
                user.setPhone(userUpdateRequest.getPhone());
                user.setAddress(userUpdateRequest.getAddress());
                userToUpdate=user;
            }
        }
        return UserMapper.convertToDto(userToUpdate);


    }

    @Override
    public boolean deleteUser(long id) {
        User userToDelete = userDao.findAll().stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElse(null);
        if (userToDelete != null) {
            List<User> users = userDao.findAll().stream()
                    .filter(employee -> employee.getId() != id)
                    .collect(Collectors.toList());
            userDao.setList(users);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateAvatar(long id, AvatarRequest avatarRequest) {
        for (User user : userDao.findAll()) {
            if (user.getId() == id) {
                user.setAvatar(avatarRequest.getAvatar());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updatePassword(long id, PasswordRequest passwordRequest) {
        for (User user : userDao.findAll()) {
            if (user.getId() == id) {
                 if(user.getPassword().compareTo(passwordRequest.getOldPassword())!=0){
                     throw new InvalidOldPasswordException("Invalid old password");
                 }
                if(user.getPassword().compareTo(passwordRequest.getNewPassword())==0){
                    throw new SamePasswordException("New password cannot be the same as the old password");
                }
                user.setPassword(passwordRequest.getNewPassword());
                return true;
            }
        }
        return false;

    }

    @Override
    public String resetPassword(long id) {
        for (User user : userDao.findAll()) {
            if (user.getId() == id) {
                user.setPassword(generateRandomPassword());
                return user.getPassword();
            }
        }
        return "";
    }

    private int generateUniqueRandomId() {
        Random random = new Random();
        int newId;
        do {
            newId = random.nextInt(1000);
        } while (userDao.findAll().contains(newId));
        return newId;
    }
    //Tạo ngẫu nhiên password chỉ chứa số có độ dài 6
    public static String generateRandomPassword() {
        int passwordLength = 6; // Độ dài của mật khẩu
        String validChars = "0123456789"; // Chuỗi các kí tự hợp lệ

        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < passwordLength; i++) {
            int randomIndex = random.nextInt(validChars.length());
            char randomChar = validChars.charAt(randomIndex);
            password.append(randomChar);
        }

        return password.toString();
    }
}
