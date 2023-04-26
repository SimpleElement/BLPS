package com.example.BLPS_l1.services.news.service.web.model.converters;

import com.example.BLPS_l1.services.news.models.News;
import com.example.BLPS_l1.services.news.service.web.model.dto.NewsDto;
import org.springframework.core.convert.converter.Converter;

import java.math.BigInteger;
import java.util.stream.Collectors;

public class ConverterNewsToNewsDto implements Converter<News, NewsDto>  {

    ConverterLikeToLikeDto converterLikeToLikeDto;
    ConverterCommentToCommentDto converterCommentToCommentDto;

    public ConverterNewsToNewsDto(ConverterLikeToLikeDto converterLikeToLikeDto, ConverterCommentToCommentDto converterCommentToCommentDto) {
        this.converterLikeToLikeDto = converterLikeToLikeDto;
        this.converterCommentToCommentDto = converterCommentToCommentDto;
    }

    @Override
    public NewsDto convert(News source) {
        NewsDto newsDto = new NewsDto();

        newsDto.setId(BigInteger.valueOf(source.getId()));
        newsDto.setAuthor(source.getAuthor());
        newsDto.setTopic(source.getTopic());
        newsDto.setDescription(source.getDescription());
        newsDto.setData(source.getData());
        newsDto.setLikes(source.getLikes().stream().map(e -> converterLikeToLikeDto.convert(e)).collect(Collectors.toList()));
        newsDto.setComments(source.getComments().stream().map(e -> converterCommentToCommentDto.convert(e)).collect(Collectors.toList()));
        return newsDto;
    }
}
