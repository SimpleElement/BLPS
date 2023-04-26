package com.example.BLPS_l1.services.news.dao;

import com.example.BLPS_l1.services.news.models.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Integer> {

}
