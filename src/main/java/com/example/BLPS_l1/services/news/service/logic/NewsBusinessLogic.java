package com.example.BLPS_l1.services.news.service.logic;

import java.util.List;

import com.example.BLPS_l1.authentication.dao.UserRepository;
import com.example.BLPS_l1.authentication.models.User;
import com.example.BLPS_l1.services.news.dao.CommentRepository;
import com.example.BLPS_l1.services.news.dao.LikeRepository;
import com.example.BLPS_l1.services.news.dao.NewsRepository;
import com.example.BLPS_l1.services.news.models.Comment;
import com.example.BLPS_l1.services.news.models.Like;
import com.example.BLPS_l1.services.news.models.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Date;

@Service
public class NewsBusinessLogic {

    @Autowired
    NewsRepository newsRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    LikeRepository likeRepository;

    @Autowired
    CommentRepository commentRepository;

    public List<News> getNews() {
        return newsRepository.findAll();
    }

    @Transactional
    public void likeNews(News news) {
            Assert.state(newsRepository.existsById(news.getId()), "Новости, которой вы хотите поставить лайк, не существует");
            News bdNews = newsRepository.findNewsById(news.getId());

            Assert.state(userRepository.existsByUsername(SecurityContextHolder.getContext().getAuthentication().getName()), "Ошибка контекста пользователя");
            User bdUser = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());

            if (likeRepository.existsLikeByNewsAndUser(bdNews, bdUser)) {
                likeRepository.removeByNewsAndUser(bdNews, bdUser);
            } else {
                Like like = new Like();
                like.setNews(bdNews);
                like.setUser(bdUser);
                likeRepository.save(like);
            }
    }

    public void commentNews(Comment comment) {
            Assert.state(newsRepository.existsById(comment.getNews().getId()), "Новости, которую вы пытаетесь прокомментировать, не существует");
            News bdNews = newsRepository.findNewsById(comment.getNews().getId());

            Assert.state(userRepository.existsByUsername(SecurityContextHolder.getContext().getAuthentication().getName()), "Ошибка контекста пользователя");
            User bdUser = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());

            Comment bdComment = new Comment();
            bdComment.setNews(bdNews);
            bdComment.setUser(bdUser);
            bdComment.setContent(comment.getContent());
            bdComment.setDate(new Date());

            commentRepository.save(bdComment);
    }
}
