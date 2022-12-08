package com.example.demo.controllers;

import com.example.demo.domain.News;
import com.example.demo.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/main/news")

public class NewsController {

    private final NewsService newsService;
    @Autowired
    public NewsController(NewsService newsService){this.newsService = newsService;}

    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @GetMapping
    public List <News>  getNews(Long newsId){
        return newsService.getNews();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public void registerNewStudent(@RequestBody News news){
        newsService.addNews(news);
    }

}
