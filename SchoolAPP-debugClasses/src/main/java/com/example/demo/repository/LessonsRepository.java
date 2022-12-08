package com.example.demo.repository;
import com.example.demo.domain.Lessons;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonsRepository extends JpaRepository<Lessons, Integer> {

}
