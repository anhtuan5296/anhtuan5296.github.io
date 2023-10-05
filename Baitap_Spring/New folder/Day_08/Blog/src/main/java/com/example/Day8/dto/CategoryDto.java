package com.example.Day8.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CategoryDto {
    private Integer id;
    private String name;
    private Long used;
}
