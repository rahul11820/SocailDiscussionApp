package com.rahul.user.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "discussion_id", referencedColumnName = "id")
    private Discussion discussion;

    @ManyToOne
    @JoinColumn(name = "byUserId", referencedColumnName = "id")
    private User byUser;

    private String comment;

    @Column(nullable = true)
    private Long parentCommentId;

    @Column(nullable = false)
    private LocalDateTime createdOn;

    @OneToMany(mappedBy = "comment")
    private List<CommentLike> likes;

}