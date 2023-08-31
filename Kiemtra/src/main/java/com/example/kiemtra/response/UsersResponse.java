package com.example.kiemtra.response;

import com.example.kiemtra.dto.UserDto;
import lombok.Data;

import java.util.List;

@Data
public class UsersResponse {
    private List<UserDto> data;
    private long currentPage;
    private long size;
    private long totalPage;
}
