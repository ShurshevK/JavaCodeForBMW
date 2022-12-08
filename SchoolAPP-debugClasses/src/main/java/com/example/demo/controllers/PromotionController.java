package com.example.demo.controllers;


import com.example.demo.domain.Promotion;
import com.example.demo.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/main/promotions")

public class PromotionController {

    private final PromotionService promotionService;

    @Autowired
    public PromotionController(PromotionService promotionService){this.promotionService = promotionService;}

    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @GetMapping
    public List<Promotion> getPromotions(){
        return promotionService.getPromotions();}

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public void registerNewPromotion(@RequestBody Promotion promotion){
        promotionService.addPromotion(promotion);
    }


}
