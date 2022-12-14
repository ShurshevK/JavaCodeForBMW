package com.example.demo.repository;

import com.example.demo.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{
    @Query(value = "Select * from event e  left join course c on e.event_id=c.id", nativeQuery = true)
    List<Object[]> ConnectCalendarAndCourse();

}