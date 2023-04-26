package com.example.BLPS_l1.services.news.service.web.model.converters;

import com.example.BLPS_l1.services.news.models.Like;
import com.example.BLPS_l1.services.news.service.web.model.dto.LikeDto;
import org.springframework.core.convert.converter.Converter;

public class ConverterLikeToLikeDto implements Converter<Like, LikeDto> {

    @Override
    public LikeDto convert(Like source) {
        LikeDto likeDto = new LikeDto();

        likeDto.setUsername(source.getUser().getUsername());
        return likeDto;
    }
}
