package com.example.demo.repository;

import java.util.Optional;

import com.example.demo.SecurityConfig.domains.ERole;
import com.example.demo.SecurityConfig.domains.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
