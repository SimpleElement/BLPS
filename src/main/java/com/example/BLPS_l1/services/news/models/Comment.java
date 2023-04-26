package com.example.BLPS_l1.services.news.models;

import com.example.BLPS_l1.authentication.models.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "comments_of_news")
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jpasequence_comments_of_news")
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "news_id")
    private News news;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "content")
    private String content;

    @Column(name = "create_date")
    private Date date;
}
