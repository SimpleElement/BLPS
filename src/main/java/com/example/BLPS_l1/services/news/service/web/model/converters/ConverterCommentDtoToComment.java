package com.example.BLPS_l1.services.news.service.web.model.converters;

import com.example.BLPS_l1.services.news.models.Comment;
import com.example.BLPS_l1.services.news.models.News;
import com.example.BLPS_l1.services.news.service.web.model.dto.CommentDto;
import org.springframework.core.convert.converter.Converter;

public class ConverterCommentDtoToComment implements Converter<CommentDto, Comment> {

    @Override
    public Comment convert(CommentDto source) {
        Comment comment = new Comment();
        News news = new News();

        news.setId(source.getNews_id().intValue());
        comment.setNews(news);
        comment.setContent(source.getContent());
        return comment;
    }
}
