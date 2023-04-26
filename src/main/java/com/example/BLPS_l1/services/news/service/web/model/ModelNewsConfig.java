package com.example.BLPS_l1.services.news.service.web.model;

import com.example.BLPS_l1.services.news.service.web.model.converters.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ModelNewsConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new ConverterCommentDtoToComment());
        registry.addConverter(new ConverterCommentToCommentDto());
        registry.addConverter(new ConverterLikeDtoToLike());
        registry.addConverter(new ConverterLikeToLikeDto());
        registry.addConverter(new ConverterNewsDtoToNews());
        registry.addConverter(new ConverterNewsToNewsDto(new ConverterLikeToLikeDto(), new ConverterCommentToCommentDto()));
    }
}
