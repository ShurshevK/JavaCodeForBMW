package com.example.demo.repository;

import com.example.demo.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


    @Query(value = "select student.student_id, student.student_name, course.course_name from student Inner JOIN course ON student.student_id=course.id", nativeQuery = true)
    List<Object[]> findStudent();
    Optional<Student> findStudentByPhoneNumber(String PhoneNumber);



}
