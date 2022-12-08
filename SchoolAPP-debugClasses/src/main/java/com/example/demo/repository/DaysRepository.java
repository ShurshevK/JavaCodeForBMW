package com.example.demo.repository;

import com.example.demo.domain.Days;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DaysRepository extends JpaRepository<Days, Long> {
}
