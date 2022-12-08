package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import com.example.demo.SecurityConfig.domains.User;
import com.example.demo.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    @Query(nativeQuery = true, value = "INSERT into student (id from users WHERE :id > 1")
    List<Student> moveStudent(long id);

}
