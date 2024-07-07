package com.rahul.user.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class DiscussionLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "likedByUserId", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "discussionId", referencedColumnName = "id")
    private Discussion discussion;
}