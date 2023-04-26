package com.example.BLPS_l1.services.news.service.web.model.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.math.BigInteger;
import java.util.Date;

@Getter
@Setter
public class CommentDto {

    @JsonView
    @NotNull(message = "Необходимо указать news_id новости, которое не может быть пустым")
    @Min(value = 0, message = "news_id должен быть больше 0")
    @Max(value = 2147483647, message = "news_id должен быть меньше 2147483647")
    private BigInteger news_id;

    private String username;

    @JsonView
    @NotBlank(message = "Необходимо указать content новости, который не может быть пустым")
    @Size(max = 500, message = "Максимальный размер comment 500 символов")
    private String content;

    private Date date;
}
