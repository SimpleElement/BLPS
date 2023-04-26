package com.example.BLPS_l1.services.mail.service.web.model.converters;

import com.example.BLPS_l1.services.mail.models.Message;
import com.example.BLPS_l1.services.mail.service.web.model.dto.MessageDto;
import org.springframework.core.convert.converter.Converter;

public class ConverterMessageToMessageDto implements Converter<Message, MessageDto> {


    @Override
    public MessageDto convert(Message source) {
        MessageDto message = new MessageDto();

        message.setUser(source.getUser().getUsername());
        message.setTopic(source.getTopic());
        message.setContent(source.getContent());
        message.setSender(source.getSender());
        return message;
    }
}
