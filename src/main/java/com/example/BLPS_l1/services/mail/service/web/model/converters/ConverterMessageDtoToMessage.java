package com.example.BLPS_l1.services.mail.service.web.model.converters;

import com.example.BLPS_l1.authentication.models.User;
import com.example.BLPS_l1.services.mail.models.Message;
import org.springframework.core.convert.converter.Converter;
import com.example.BLPS_l1.services.mail.service.web.model.dto.MessageDto;

public class ConverterMessageDtoToMessage implements Converter<MessageDto, Message> {

    @Override
    public Message convert(MessageDto source) {
        Message message = new Message();
        User user = new User();
        user.setUsername(source.getUser());

        message.setUser(user);
        message.setTopic(source.getTopic());
        message.setContent(source.getContent());
        return message;
    }
}
