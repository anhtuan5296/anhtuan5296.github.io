package com.example.kiemtra.controller;

import com.example.kiemtra.dto.UserDto;
import com.example.kiemtra.request.AvatarRequest;
import com.example.kiemtra.request.PasswordRequest;
import com.example.kiemtra.request.UserRequest;
import com.example.kiemtra.request.UserUpdateRequest;
import com.example.kiemtra.response.UsersResponse;
import com.example.kiemtra.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<?> getUsers(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int limit
    ) {
        List<UserDto> userDtoList = userService.getAllUsers(page, limit);
        UsersResponse response = new UsersResponse();
        response.setData(userDtoList);
        response.setCurrentPage(page);
        response.setSize((userDtoList.size()<=limit?userDtoList.size():limit));
        response.setTotalPage(userService.getTotalPages(limit));

        return ResponseEntity.ok(response);
    }

    @GetMapping("/search")
    public List<UserDto> searchUsersByName(@RequestParam String name) {
        List<UserDto> userDtoList = userService.searchByName(name);
        return userDtoList;
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable long id) {
        UserDto user = userService.getUserById(id);
        return user;
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserRequest userRequest) {
        UserDto user = userService.addUser(userRequest);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable long id, @RequestBody UserUpdateRequest userUpdateRequest) {
        UserDto user = userService.updateUser(id, userUpdateRequest);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable long id) {
        boolean deleted = userService.deleteUser(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}/update-avatar")
    public ResponseEntity updateAvatar(@PathVariable("id") long id, @RequestBody AvatarRequest avatarRequest) {
        boolean updated = userService.updateAvatar(id, avatarRequest);
        if (updated) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}/update-password")
    public ResponseEntity<Void> updatePassword(
            @PathVariable("id") long id,
            @RequestBody PasswordRequest passwordRequest
    ) {
        boolean updated = userService.updatePassword(id, passwordRequest);
        if (updated) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/{id}/forgot-password")
    public ResponseEntity<String> forgotPassword(@PathVariable("id") long id) {
        String newPassword = userService.resetPassword(id);
        if (newPassword.equals("")) {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok("Mật khẩu mới của người dùng có id " + id + " là: " + newPassword);
        }
    }


}
