package com.example.Day8.repository;

import com.example.Day8.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByRoles_NameIn(List<String> roles);

    <T> T findByEmail(String email, Class<T> type);
}
