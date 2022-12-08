package com.example.demo.repository;

import com.example.demo.domain.ScheduleResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ScheduleResponseRepository extends JpaRepository<ScheduleResponse, Long> {
    Optional<ScheduleResponse> findByDate(String date);
}
