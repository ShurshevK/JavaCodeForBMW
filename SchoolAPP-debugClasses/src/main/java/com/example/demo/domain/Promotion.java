package com.example.demo.domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Table(name = "promotion")
public class Promotion {


    @Id
    @SequenceGenerator(
            name = "promotion_sequence",
            sequenceName = "promotion_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "promotion_sequence"
    )
    @Column(
            name = "promotionId",
            nullable = false
    )
    private Long promotionId;
    private String promotionImageLink;
    private String promotionText;

    public Promotion(Long promotionId, String imageLink, String text) {
        this.promotionId = promotionId;
        this.promotionImageLink = imageLink;
        this.promotionText = text;
    }

    public Long getPromotionId() {
        return promotionId;
    }

    public String getPromotionImageLink() {
        return promotionImageLink;
    }

    public String getPromotionText() {
        return promotionText;
    }

    public void setPromotionId(Long promotionId) {
        this.promotionId = promotionId;
    }

    public void setPromotionImageLink(String promotionImageLink) {
        this.promotionImageLink = promotionImageLink;
    }

    public void setPromotionText(String promotionText) {
        this.promotionText = promotionText;
    }
}
