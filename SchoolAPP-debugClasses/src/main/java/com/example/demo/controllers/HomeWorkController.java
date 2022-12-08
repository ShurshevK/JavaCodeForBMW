package com.example.demo.controllers;

import com.example.demo.domain.HomeWork;
import com.example.demo.repository.HomeWorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/main/homework")


public class HomeWorkController {
    @Autowired
    HomeWorkRepository homeWorkRepository;

    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @GetMapping
    List<HomeWork> getHomeWork(){
        return homeWorkRepository.findAll();
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    HomeWork createHomeWork(@RequestBody HomeWork homeWork){
        return homeWorkRepository.save(homeWork);
    }
}
