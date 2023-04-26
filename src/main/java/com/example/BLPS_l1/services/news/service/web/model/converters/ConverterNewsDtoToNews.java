package com.example.BLPS_l1.services.news.service.web.model.converters;

import com.example.BLPS_l1.services.news.models.News;
import com.example.BLPS_l1.services.news.service.web.model.dto.NewsDto;
import org.springframework.core.convert.converter.Converter;

public class ConverterNewsDtoToNews implements Converter<NewsDto, News> {

    @Override
    public News convert(NewsDto source) {
        News news = new News();

        news.setId(source.getId().intValue());
        return news;
    }
}
