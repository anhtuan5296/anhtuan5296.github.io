package com.example.Day8.repository;

import com.example.Day8.entity.Blog;
import com.example.Day8.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
import java.util.Optional;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
    // 1.Lấy tất cả blog
    Page<Blog> findByStatusTrueOrderByPublishedAtDesc(Pageable pageable);
    Page<Blog> findByStatus( Boolean status, Pageable pageable);

    // 2.
    List<Blog> findByTitleContainingIgnoreCase(String title);

    // 3.

    // 5.
    @Query("""
            SELECT b
            FROM Blog b
            JOIN b.categories c
            WHERE c.name = ?1 AND b.status = true
            ORDER BY b.publishedAt DESC
            """)
    List<Blog> findByCategoryName(String name);
    // 6.
    Optional<Blog> findByIdAndSlugAndStatusTrue(Integer id, String slug);
    Optional<Blog> findByIdAndSlugAndStatus(Integer id, String slug, boolean status);
}
