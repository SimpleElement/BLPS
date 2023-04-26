package com.example.BLPS_l1.services.mail.service.web.model.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class MessageDto {

    @JsonView
    @NotBlank(message = "Необходимо указать имя получателя, которое не может быть пустым")
    @Size(max = 50, message = "Имя пользователя должно быть длинной от 0 до 50 символов")
    private String user;

    @JsonView
    @NotBlank(message = "Необходимо указать тему письма, которое не может быть пустым")
    @Size(max = 250, message = "Тема письма должна быть длинной от 0 до 250 символов")
    private String topic;

    @JsonView
    @NotBlank(message = "Необходимо указать содержание письма, которое не может быть пустым")
    @Size(max = 3000, message = "Содержание письма должно быть длинной от 0 до 3000 символов")
    private String content;

    private String sender;
}
