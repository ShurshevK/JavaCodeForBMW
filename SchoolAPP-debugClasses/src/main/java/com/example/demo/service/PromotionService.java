package com.example.demo.service;


import com.example.demo.domain.Promotion;
import com.example.demo.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PromotionService {

    @Autowired
    public PromotionRepository promotionRepository;

    @Autowired
    public PromotionService(PromotionRepository promotionRepository){
        this.promotionRepository = promotionRepository;
    }


    public List<Promotion> getPromotions() {
        return promotionRepository.findAll();
    }

    public void addPromotion(Promotion promotion){

        promotionRepository.save(promotion);

    }
}
