package com.example.BLPS_l1.services.mail.service.logic;

import com.example.BLPS_l1.authentication.dao.UserRepository;
import com.example.BLPS_l1.authentication.models.User;
import com.example.BLPS_l1.services.mail.dao.MessageRepository;
import com.example.BLPS_l1.services.mail.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MailBusinessLogic {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MessageRepository messageRepository;

    public List<Message> getMessages() {
        return messageRepository.findAllByUser_Username(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    public void writeMessage(Message message) {
        Assert.state(userRepository.existsByUsername(message.getUser().getUsername()), "Пользователь, которому вы хотите отправить сообщение, не найден");

        Message bdMessage = new Message();
        User bdUser = userRepository.findByUsername(message.getUser().getUsername());

        bdMessage.setUser(bdUser);
        bdMessage.setSender(SecurityContextHolder.getContext().getAuthentication().getName());
        bdMessage.setTopic(message.getTopic());
        bdMessage.setContent(message.getContent());
        bdMessage.setDate(new Date());

        messageRepository.save(bdMessage);
    }
}
