package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Course;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CourseService
{
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> listAll() {
        return courseRepository.findAll();
    }

    public void save(Course course) {
        courseRepository.save(course);
    }

    public Course get(long id) {
        return courseRepository.findById(id).get();
    }

    public void delete(long id) {
        courseRepository.deleteById(id);
    }

}