package com.example.demo.controllers;


import com.example.demo.domain.ScheduleResponse;
import com.example.demo.service.ScheduleResponseService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/main/schedule")
public class ScheduleResponseController {

    private final ScheduleResponseService scheduleResponseService;


    public ScheduleResponseController(ScheduleResponseService scheduleResponseService){
        this.scheduleResponseService = scheduleResponseService;}

    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @GetMapping
    public List<ScheduleResponse> getScheduleResponse(){
        return scheduleResponseService.getScheduleResponse();}

    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @GetMapping(path = "/{date}")
    public ScheduleResponse getScheduleResponse(@PathVariable("date") String date){
        return scheduleResponseService.findByDate(date)
                .orElse(null);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public void addScheduleResponse(@RequestBody ScheduleResponse scheduleResponse){
        scheduleResponseService.addScheduleResponse(scheduleResponse);
    }


}
