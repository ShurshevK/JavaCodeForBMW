package com.example.demo.controllers;


import com.example.demo.domain.CancelLessons;
import com.example.demo.service.CancelLessonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/main/classStatus")
public class CancelClassController {

    @Autowired
    private CancelLessonsService cancelLessonsService;


    @GetMapping
    public List<CancelLessons> getCancelClass(){
        return cancelLessonsService.getCancelClass();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public void registerNewCancelStatus(@RequestBody CancelLessons cancelLessons){
        cancelLessonsService.addCancelClass(cancelLessons);
    }

}
