package com.example.BLPS_l1.services.news.service.web.model.converters;

import com.example.BLPS_l1.authentication.models.User;
import com.example.BLPS_l1.services.news.models.Like;
import com.example.BLPS_l1.services.news.service.web.model.dto.LikeDto;
import org.springframework.core.convert.converter.Converter;

public class ConverterLikeDtoToLike implements Converter<LikeDto, Like> {

    @Override
    public Like convert(LikeDto source) {
        Like like = new Like();
        User user = new User();

        user.setUsername(source.getUsername());
        like.setUser(user);
        return like;
    }
}
