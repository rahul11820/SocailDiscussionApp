package com.rahul.user.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Follower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "followingUserId", referencedColumnName = "id")
    private User followingUser;

    @ManyToOne
    @JoinColumn(name = "followedUserId", referencedColumnName = "id")
    private User followedUser;
}