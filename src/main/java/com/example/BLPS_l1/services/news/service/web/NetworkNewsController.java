package com.example.BLPS_l1.services.news.service.web;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.BLPS_l1.services.mail.models.Message;
import com.example.BLPS_l1.services.news.models.Comment;
import com.example.BLPS_l1.services.news.models.News;
import com.example.BLPS_l1.services.news.service.logic.NewsBusinessLogic;
import com.example.BLPS_l1.services.news.service.web.model.dto.CommentDto;
import com.example.BLPS_l1.services.news.service.web.model.dto.NewsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@CrossOrigin
@RestController
@RequestMapping("/api/news")
public class NetworkNewsController {

    @Autowired
    NewsBusinessLogic newsBusinessLogic;

    @Autowired
    ConversionService conversionService;

    @GetMapping(path = "/getNews")
    public List<NewsDto> getNews(@RequestParam Map<String,String> allParams) {
        if (allParams.size() > 0)
            throw new IllegalStateException("Лишние параметры в url");
        return newsBusinessLogic.getNews().stream().map(e -> conversionService.convert(e, NewsDto.class)).collect(Collectors.toList());
    }

    @PostMapping(path = "/likeNews")
    public void likeNew(@RequestBody NewsDto newsDto, @RequestParam Map<String,String> allParams) {
        if (allParams.size() > 0)
            throw new IllegalStateException("Лишние параметры в url: " + String.join(", ", allParams.keySet()));
        newsBusinessLogic.likeNews(conversionService.convert(newsDto, News.class));
    }

    @PostMapping(path = "/commentNews")
    public void commentNew(@RequestBody CommentDto commentDto, @RequestParam Map<String,String> allParams) {
        if (allParams.size() > 0) {
            throw new IllegalStateException("Лишние параметры в url: " + String.join(", ", allParams.keySet()));
        }
        newsBusinessLogic.commentNews(conversionService.convert(commentDto, Comment.class));
    }
}
