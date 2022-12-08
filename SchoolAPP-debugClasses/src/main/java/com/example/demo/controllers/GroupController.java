package com.example.demo.controllers;


import com.example.demo.Calendar.domain.Event;
import com.example.demo.Calendar.repository.EventRepository;
import com.example.demo.domain.Group;
import com.example.demo.repository.GroupRepository;
import com.example.demo.domain.HomeWork;
import com.example.demo.repository.HomeWorkRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/main/groups")
public class GroupController {

    @Autowired
    GroupRepository groupRepository;
    @Autowired
    HomeWorkRepository homeWorkRepository;
    @Autowired
    EventRepository eventRepository;


    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @GetMapping
    List<Group> getGroups(){
        return groupRepository.findAll();
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    Group createGroup(@RequestBody Group group){
        return groupRepository.save(group);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @JsonIgnore
    @PutMapping("/{groupId}/homework/{homeWorkId}")
    Group assignGroupToHomeWork(
            @PathVariable Long groupId,
            @PathVariable Long homeWorkId
    ){
        Group group = groupRepository.findById(groupId).get();
        HomeWork homeWork = homeWorkRepository.findById(homeWorkId).get();
        group.assignedHomeWork(homeWork);
        return groupRepository.save(group);

    }
    @JsonIgnore
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{groupId}/api/events/{eventsId}")
    Group assignGroupToEvent(
            @PathVariable Long groupId,
            @PathVariable Long eventId
    ){
        Group group = groupRepository.findById(groupId).get();
        Event event = eventRepository.findById(eventId).get();
        group.assignedEvent(event);
        return groupRepository.save(group);

    }
}
