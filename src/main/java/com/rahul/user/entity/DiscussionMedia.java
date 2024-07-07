package com.rahul.user.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class DiscussionMedia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "discussion_id", referencedColumnName = "id")
    private Discussion discussion;

    @Column(nullable = false)
    private String mediaUrl;

    @Column(nullable = false)
    private Long position;
}