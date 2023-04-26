package com.example.BLPS_l1.services.mail.service.web;

import com.example.BLPS_l1.services.mail.models.Message;
import com.example.BLPS_l1.services.mail.service.logic.MailBusinessLogic;
import com.example.BLPS_l1.services.mail.service.web.model.dto.MessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Validated
@CrossOrigin
@RestController
@RequestMapping("/api/mail")
public class NetworkMailController {

    @Autowired
    MailBusinessLogic mailBusinessLogic;

    @Autowired
    ConversionService conversionService;

    @GetMapping("/getMessages")
    public List<MessageDto> getMessages(@RequestParam Map<String,String> allParams) {
        if (allParams.size() > 0)
            throw new IllegalStateException("Лишние параметры в url");
        return mailBusinessLogic.getMessages().stream()
                .map(e -> conversionService.convert(e, MessageDto.class))
                .collect(Collectors.toList());
    }

    @PostMapping("/writeMessage")
    public void writeMessage(@Valid @RequestBody MessageDto messageDto, @RequestParam Map<String,String> allParams) {
        if (allParams.size() > 0)
            throw new IllegalStateException("Лишние параметры в url");
        mailBusinessLogic.writeMessage(conversionService.convert(messageDto, Message.class));
    }
}
