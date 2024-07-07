package com.rahul.user.entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "comment_likes")
public class CommentLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "likedByUserId", referencedColumnName = "id")
    private User likedByUser;

    @ManyToOne
    @JoinColumn(name = "comment_id", referencedColumnName = "id")
    private Comment comment;
}