package com.example.Day8.repository;

import com.example.Day8.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Integer> {
    List<Image> findByUser_IdOrderByCreatedAtDesc(Integer id);
}
