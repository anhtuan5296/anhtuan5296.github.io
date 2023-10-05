package com.example.Day8;

import com.example.Day8.dto.CategoryDto;
import com.example.Day8.repository.CategoryRepository;
import com.example.Day8.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryTest {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private UserRepository userRepository;


    @Test
    void test_find_all_category_dto() {
        List<CategoryDto> categoryDtos = categoryRepository.getAllCategoryDtoNQ();
        categoryDtos.forEach(System.out::println);
    }


}
