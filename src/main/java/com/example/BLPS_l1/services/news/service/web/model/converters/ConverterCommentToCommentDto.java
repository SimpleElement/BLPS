package com.example.BLPS_l1.services.news.service.web.model.converters;

import com.example.BLPS_l1.services.news.models.Comment;
import com.example.BLPS_l1.services.news.service.web.model.dto.CommentDto;
import org.springframework.core.convert.converter.Converter;

import java.math.BigInteger;

public class ConverterCommentToCommentDto implements Converter<Comment, CommentDto>  {

    @Override
    public CommentDto convert(Comment source) {
        CommentDto commentDto = new CommentDto();

        commentDto.setNews_id(BigInteger.valueOf(source.getNews().getId()));
        commentDto.setUsername(source.getUser().getUsername());
        commentDto.setContent(source.getContent());
        commentDto.setDate(source.getDate());
        return commentDto;
    }
}
