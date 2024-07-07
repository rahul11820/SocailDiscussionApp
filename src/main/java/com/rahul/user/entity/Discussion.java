package com.rahul.user.entity;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimerTask;


@Data
@Entity
@Document(indexName = "discussions")
public class Discussion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<DiscussionMedia> medias;

    @OneToMany
    private Set<HashTag> hashTags;

    private String text;

    @OneToMany
    private List<Comment> comments;

    @OneToMany
    private List<DiscussionLike> likes;

    private Long createdOn;
}
