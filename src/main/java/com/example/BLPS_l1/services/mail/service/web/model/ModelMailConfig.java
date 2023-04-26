package com.example.BLPS_l1.services.mail.service.web.model;

import com.example.BLPS_l1.services.mail.service.web.model.converters.ConverterMessageDtoToMessage;
import com.example.BLPS_l1.services.mail.service.web.model.converters.ConverterMessageToMessageDto;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ModelMailConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new ConverterMessageDtoToMessage());
        registry.addConverter(new ConverterMessageToMessageDto());
    }
}