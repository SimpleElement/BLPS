package com.example.BLPS_l1.services.news.models;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "news")
public class News implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jpasequence_news")
    private Integer id;

    @Column(name = "author")
    private String author;

    @Column(name = "topic")
    private String topic;

    @Column(name = "description")
    private String description;

    @Column(name = "data")
    private Date data;

    @OneToMany(mappedBy = "news", fetch=FetchType.LAZY)
    private List<Like> likes;

    @OneToMany(mappedBy = "news", fetch=FetchType.LAZY)
    private List<Comment> comments;
}
