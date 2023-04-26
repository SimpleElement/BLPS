package com.example.BLPS_l1.services.news.dao;

import com.example.BLPS_l1.authentication.models.User;
import com.example.BLPS_l1.services.news.models.Like;
import com.example.BLPS_l1.services.news.models.News;
import org.springframework.data.repository.CrudRepository;

public interface LikeRepository extends CrudRepository<Like, Integer> {
    boolean existsLikeByNewsAndUser(News news, User user);
    void removeByNewsAndUser(News news, User user);
}
