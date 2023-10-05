package com.example.Day8.repository;

import com.example.Day8.dto.CategoryDto;
import com.example.Day8.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
   List<Category> findByBlogs_Status(Boolean status);

//     Lấy danh sách category và số lượng bài viết áp dụng
    @Query("""
        SELECT new com.example.Day8.dto.CategoryDto(c.id, c.name, COUNT(b.id))
        FROM Category c
        JOIN c.blogs b
        WHERE b.status = true
        GROUP BY c.id, c.name
    """)
    List<CategoryDto> getAllCategoryDto();

    // Lấy danh sách category và số lượng bài viết áp dụng sử dụng native query
//    @Query(nativeQuery = true, name = "getAllCategoryDtoNQ")
//    List<CategoryDto> getAllCategoryDtoNQ();

    List<Category>findByIdIn(List<Integer> ids);
}
