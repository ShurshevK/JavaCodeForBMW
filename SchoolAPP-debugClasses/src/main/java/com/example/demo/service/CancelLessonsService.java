package com.example.demo.service;


import com.example.demo.domain.CancelLessons;
import com.example.demo.repository.CancelLessonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CancelLessonsService {

    @Autowired
    public CancelLessonsRepository cancelLessonsRepository;

    @Autowired
    public CancelLessonsService(CancelLessonsRepository cancelLessonsRepository){
        this.cancelLessonsRepository = cancelLessonsRepository;
    }


    public List<CancelLessons> getCancelClass() {return cancelLessonsRepository.findAll();
    }

    public void addCancelClass(CancelLessons cancelLessons){
        cancelLessonsRepository.save(cancelLessons);
    }
}
