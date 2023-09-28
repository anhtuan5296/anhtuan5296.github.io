package org.example.Ex12;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    // Method Query
    List<UserDto> findAllBy();

    // JPQL Query
    @Query("SELECT new org.example.Ex12.UserDto(u.id, u.name, u.email) FROM User u")
    List<UserDto> findAllUsers();

    // Native Query
    @Query(value = "SELECT id, name, email FROM users", nativeQuery = true)
    List<UserDto> findAllUsersNQ();

    // Projection
    List<UserProjection> findAllByProjection();
}
