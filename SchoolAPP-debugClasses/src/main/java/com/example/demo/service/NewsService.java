package com.example.demo.service;




import com.example.demo.domain.News;
import com.example.demo.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service

public class NewsService {
    @Autowired
    public NewsRepository newsRepository;

    @Autowired
    public NewsService(NewsRepository newsRepository){
        this.newsRepository = newsRepository;
    }


    public List<News> getNews() {
        return newsRepository.findAll();
    }

    public void addNews(News news){

        newsRepository.save(news);

    }
}

