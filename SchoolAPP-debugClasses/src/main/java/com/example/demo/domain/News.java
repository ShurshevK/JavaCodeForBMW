package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Table(name = "news")

public class News {

    @Id
    @SequenceGenerator(
            name = "news_sequence",
            sequenceName = "news_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "news_sequence"
    )
    @Column(
            name = "newsId",
            nullable = false
    )
    private Long newsId;
    public String newsTitle;
    private String imageLink;
    private String text;

    public News(Long newsId, String imageLink, String text, String newsTitle) {
        this.newsId = newsId;
        this.imageLink = imageLink;
        this.text = text;
        this.newsTitle = newsTitle;
    }

    public Long getNewsId() {
        return newsId;
    }

    public String getImageLink() {
        return imageLink;
    }

    public String getText() {
        return text;
    }

    public void setNewsId(Long newsId) {
        this.newsId = newsId;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "News{" +
                "newsId=" + newsId +
                ", newsTitle='" + newsTitle + '\'' +
                ", imageLink='" + imageLink + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
