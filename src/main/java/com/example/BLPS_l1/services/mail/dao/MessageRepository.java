package com.example.BLPS_l1.services.mail.dao;

import java.util.List;

import com.example.BLPS_l1.services.mail.models.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository <Message, Integer> {

    List<Message> findAllByUser_Username(String username);
}
