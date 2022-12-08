package com.example.demo.service;


import com.example.demo.domain.Course;
import com.example.demo.domain.Group;
import com.example.demo.domain.HomeWork;
import com.example.demo.domain.ScheduleResponse;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.GroupRepository;
import com.example.demo.repository.ScheduleResponseRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleResponseService {

    @Autowired
    ScheduleResponseRepository scheduleResponseRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    GroupRepository groupRepository;

    @Autowired
    public ScheduleResponseService(ScheduleResponseRepository scheduleResponseRepository){
        this.scheduleResponseRepository = scheduleResponseRepository;
    }
    public List<ScheduleResponse> getScheduleResponse() {
        return scheduleResponseRepository.findAll();
    }

    public Optional<ScheduleResponse> findByDate(String date) {
        return scheduleResponseRepository.findByDate(date);
    }

    public void addScheduleResponse(ScheduleResponse scheduleResponse){

        scheduleResponseRepository.save(scheduleResponse);

    }
    @JsonIgnore
    @PutMapping("/{scheduleResponseId}/course/{id}")
    ScheduleResponse assignScheduleResponseToCourse(
            @PathVariable Long scheduleResponseId,
            @PathVariable Long id
    ){
        ScheduleResponse scheduleResponse = scheduleResponseRepository.findById(scheduleResponseId).get();
        Course course = courseRepository.findById(id).get();
        scheduleResponse.assignedCourses(course);
        return scheduleResponseRepository.save(scheduleResponse);

    }
    @JsonIgnore
    @PutMapping("/{scheduleResponseId}/groups/{groupId}")
    ScheduleResponse assignScheduleResponseToGroup(
            @PathVariable Long scheduleResponseId,
            @PathVariable Long groupId
    ){
        ScheduleResponse scheduleResponse = scheduleResponseRepository.findById(scheduleResponseId).get();
        Group group = groupRepository.findById(groupId).get();
        scheduleResponse.assignedGroups(group);
        return scheduleResponseRepository.save(scheduleResponse);

    }


}
